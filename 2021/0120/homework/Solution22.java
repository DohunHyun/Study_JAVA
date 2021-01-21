package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};

        for(int case_num = 0; case_num<test_case; case_num++) {
            // 테스트 케이스 반복

            int pond_size = sc.nextInt(); //연못 사이즈
            int mosq_num = sc.nextInt(); // 소금쟁이 수

            int[][] pond = new int[pond_size][pond_size];

            for(int mosq_order = 0; mosq_order<mosq_num; mosq_order++) {
                // 모기들 점프 시작
                int x = sc.nextInt();
                int y = sc.nextInt();
                int direction = sc.nextInt();

                if(pond[x][y] == 0) { // 시작 위치에 다른 소금쟁이가 없으면 시작
                    pond[x][y] = 0;
                    x += 3*dx[direction-1]; // 3칸 이동
                    y += 3*dy[direction-1];

                    if(x>=0 && y>=0 && x<pond_size && y<pond_size
                        && pond[x][y] == 0) { // 3칸 이동한 지점 체크
                        pond[x][y] = 0;
                        x += 2*dx[direction-1]; // 2칸 이동
                        y += 2*dy[direction-1];

                        if(x>=0 && y>=0 && x<pond_size && y<pond_size
                                && pond[x][y] == 0) { // 2칸 이동한 지점 체크
                            pond[x][y] = 0;
                            x += 1*dx[direction-1]; // 1칸 이동
                            y += 1*dy[direction-1];

                            if(x>=0 && y>=0 && x<pond_size && y<pond_size
                                    && pond[x][y] == 0) { // 1칸 이동한 지점 체크
                                pond[x][y] = 1;
                            }
                        }
                    }
                } //3번의 이동 끝

            } // 소금쟁이들 점프 끝

            // 연못에 남은 소금쟁이 숫자 세기
            int alive_mosq = 0;
            for(int i=0; i<pond_size; i++) {
                for(int j=0; j<pond_size; j++) {
                    if(pond[i][j] == 1) alive_mosq++;
                }
            }
            System.out.println("#" + (case_num+1) + " " + alive_mosq);

        }
    }
}

/*
3
9 5
6 2 4
1 5 2
0 0 4
6 6 1
2 4 3
11 6
0 0 4
6 0 1
2 4 3
4 2 4
1 5 2
10 8 1
7 5
5 2 1
1 6 2
0 6 3
1 0 2
2 4 4
 */
