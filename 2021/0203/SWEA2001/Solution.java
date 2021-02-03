package SWEA2001;

import java.util.Scanner;

public class Solution {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle = 1; cycle<=testcase; cycle++) {
            int size = sc.nextInt();
            int M = sc.nextInt();
            map = new int[size][size];

            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int i=0; i<=size-M; i++) {
                for(int j=0; j<=size-M; j++) {
                    if(max < calc(i,j,M)) {
                        max = calc(i,j, M);
                    }
                }

            }

            System.out.println("#" + cycle + " " + max);
        }
    }

    private static int calc(int i, int j, int M) {
        int answer = 0;

        for(int x=i; x<i+M; x++) {
            for(int y=j; y<j+M; y++) {
                answer += map[x][y];
            }
        }

        return answer;
    }
}
