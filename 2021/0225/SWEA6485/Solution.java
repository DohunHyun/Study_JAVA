package SWEA6485;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for(int cycle=1; cycle<=testcase; cycle++) {
            int N = sc.nextInt(); // 노선 개수
            int[][] bus = new int[N][2];
            for(int i=0; i<N; i++) { // 노선 정보
                bus[i][0] = sc.nextInt();
                bus[i][1] = sc.nextInt();
            }

            int P = sc.nextInt(); // 정류장 개수
            System.out.print("#" + cycle + " ");

            for(int i=0; i<P; i++) {
                int temp = sc.nextInt();
                int tempCnt = 0;
                for(int j=0; j<N; j++) {
                    if(temp>= bus[j][0] && temp<=bus[j][1]) {
                        tempCnt++;
                    }
                }
                System.out.print(tempCnt + " ");
            }
            System.out.println();
        }
    }
}
