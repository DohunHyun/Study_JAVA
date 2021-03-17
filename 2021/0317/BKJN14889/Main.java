package BKJN14889;

import java.util.Scanner;

public class Main { // 백준 14889 스타트와 링크
    static int N;
    static int[][] map;
    static int[] selected;
    static int ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        selected = new int[N];
        ans = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        findMin(0,0);
        System.out.println(ans);

    }

    private static void findMin(int index, int num) {
        if(index == N) return;
        if(num == N/2) { // 팀 다 나눈 후!
            int[] A = new int[N/2];
            int[] B = new int[N/2];
            int sizeA=0;
            int sizeB=0;
            int scoreA=0;
            int scoreB=0;

            for(int i=0; i<N; i++) { // 팀 분리!
                if (selected[i] == 1) {
                    A[sizeA++] = i;
                } else {
                    B[sizeB++] = i;
                }
            }

            for(int i=0; i<N/2-1; i++) {
                for(int j=i+1; j<N/2; j++) {
                    scoreA += map[A[i]][A[j]] + map[A[j]][A[i]];
                    scoreB += map[B[i]][B[j]] + map[B[j]][B[i]];
                }
            }

            ans = Math.min(ans, Math.abs(scoreA - scoreB));
        }

        selected[index] = 1;
        findMin(index+1, num+1);
        selected[index] = 0;
        findMin(index+1, num);
    }
}
