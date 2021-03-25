package SWEA1263;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        final int INF = 9999999;

        for(int cycle=1; cycle<=T; cycle++) {
            int N = sc.nextInt();
//            int[][] map = new int[N][N];
            int[][] distance = new int[N][N];

            for(int i=0; i<N; i++) { // 인접행렬 완성
                for(int j=0; j<N; j++) {
                    distance[i][j] = sc.nextInt();
                    if(i!=j && distance[i][j]==0) {
                        distance[i][j]=INF;
                    }
                }
            }

            for(int k=0; k<N; k++) {
                for(int i=0; i<N; i++) {
                    if(i == k) continue;
                    for(int j=0; j<N; j++) {
                        if(i==j || j==k) continue;
                        if(distance[i][k] != INF && distance[k][j] != INF &&
                        distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }

                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                int temp = 0;
                for(int j=0; j<N; j++) {
                    if(i==j) continue;
                    temp += distance[i][j];
                }
                if(ans > temp) ans = temp;
            }

            System.out.println("#" + cycle + " " + ans);





        }
    }
}
