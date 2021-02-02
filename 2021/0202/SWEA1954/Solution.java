package SWEA1954;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle = 1; cycle<=testcase; cycle++) {
            int N = sc.nextInt();
            int[][] snail = new int[N][N];
            int direction = 1; // 우1, 하2, 좌3, 상4
            int[] dX = {0, +1, 0, -1}; // 우, 하, 좌, 상
            int[] dY = {1, 0, -1, 0};
            int count = 1;
            int x=0;
            int y=0;

            for(int i=0; i<N*N; i++) {
                snail[x][y] = count++; // 넣고

                if(direction == 1 && (y+1 == N || !(snail[x][y+1] == 0)) ) { // 오른쪽 끝까지 갔을때
                    direction = 2;
                } else if(direction == 2 && (x+1 == N || !(snail[x+1][y] == 0))) { // 아래로 가고
                    direction = 3;
                } else if(direction == 3 && (y-1 < 0 || !(snail[x][y-1] == 0) )) {
                    direction = 4;
                } else if(direction == 4 && (x-1 < 0 || !(snail[x-1][y] == 0))) {
                    direction = 1;
                }
                x += dX[direction-1];
                y += dY[direction-1];

            }

            System.out.println("#" + cycle);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
