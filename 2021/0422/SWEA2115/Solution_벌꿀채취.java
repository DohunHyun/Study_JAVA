package SWEA2115;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_벌꿀채취 {
    static int N, M, C;
    static int[][] map;
    static boolean[][] visited;
    static int A, B;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int t=1; t<=TC; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            map = new int[N][N];
            answer = 0;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            A = find();
            B = find();
            answer = A + B;

            System.out.println("#" + t + " " + answer);
        }
    }

    private static int find() {

        int honey = 0;
        int maxI = 0, maxJ = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=N-M; j++) { // 모든칸을 돌면서
                if(honey < getHoney(i, j)) { // 가장 최댓값을 찾는다
                    maxI = i;
                    maxJ = j;
                    honey = getHoney(i, j);
                }
            }
        }

        for(int i=maxJ; i<maxJ+M; i++) {  //
            visited[maxI][i] = true;
        }

        return honey;
    }

    private static int getHoney(int i, int j) {
        if(visited[i][j] || visited[i][j+M-1]) { // 이미 방문한 곳이라면
            return -1;
        }

        // 아니라면
        // 그 안에서 꿀 최대로 채취하자
        int honey = 0;
        int total = 0;

        // 그 범위 안에 있는애들로 배열 만들어서 큰거부터 담아야함.
        int[] arr = new int[M];
        int size = 0;
        for(int m=j; m<M+j; m++) {
            arr[size++] = map[i][m];
        }
        Arrays.sort(arr);
        for(int k=0; k<size; k++) {
            if(honey + arr[k] <= C) {
                honey += arr[k];
                total += Math.pow(arr[k], 2);
            }
        }

        // 다른 조합을 통해서 C에 가깝게 만들어보는게 더 높을수도 있음....


        return total;
    }
}
