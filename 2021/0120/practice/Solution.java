package com.ssafy.ws02.step3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int case_num = 0; case_num < testCase; case_num++) {

            int MAX = 0;
            int land_size = sc.nextInt();
            sc.nextLine();
            String[][] land = new String[land_size][land_size]; //배열 생성

            for(int sizeTemp = 0; sizeTemp < land_size; sizeTemp++) { // 배열 채워넣기
                String sentence = sc.nextLine();
                land[sizeTemp] = sentence.split(" ");
            }

            for(int i=0; i<land_size; i++) {
                for(int j=0; j<land_size; j++) {
                    if(land[i][j].equals("G")) { //G이면 끝.
                        continue;
                    } else { // B이면
                        if(check(land, i, j, land_size)) { //check 주변
                            if(sumB(land, i, j, land_size) > MAX)  {
                                MAX = sumB(land, i, j, land_size);
                            }
                        }

                    }

                }
            }
            System.out.println("#" + (case_num+1) + " " + MAX);
        }
    }

    private static int sumB(String[][] land, int i, int j, int land_size) {
        int sum = 0;

        for(int x=0; x<land_size; x++) {
            if(land[x][j].equals("B")) sum++;
        }

        for(int y=0; y<land_size; y++) {
            if(land[i][y].equals("B")) sum++;
        }

        return sum-1; // 본인 중복 하나 뺴기
    }

    private static boolean check(String[][] land, int i, int j, int land_size) {
        // 주변에 G 없으면 true, 있으면 false

        int[] x = {0, 1, 1, 1, 0, -1, -1, -1}; // 12시 방향부터 시계방향
        int[] y = {1, 1, 0, -1, -1, -1, 0, 1};

        for(int k=0; k<8; k++) {
            int ix = i+x[k];
            int jy = j+y[k];

            if(ix>=0 && ix<land_size && jy>=0 && jy<land_size) {
                if(land[ix][jy].equals("G")) return false;
            }
        }
        return true;

    }
}
//input data
//3
//6
//G B G G B B
//G B G G B G
//B B B B G B
//B G B B B B
//G B B B B G
//G B B B B G
//5
//G B G G B
//G B G G B
//B B B B G
//B G B B B
//G B B B B
//3
//G G B
//G B B
//B B B