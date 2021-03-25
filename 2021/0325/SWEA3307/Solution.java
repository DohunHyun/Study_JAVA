package SWEA3307;

import java.util.Scanner;

public class Solution { // 최장 증가 부분 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int cycle=1; cycle<=T; cycle++) {
            int N = sc.nextInt(); // 수열의 길이
            int[] input = new int[N];
            int[] LSI = new int[N];
            for(int i=0; i<N; i++) {
                input[i] = sc.nextInt();
                LSI[i] = 1; // 자기 자신만 있었을때 길이로 초기화!
            }

            int max = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<i; j++) {
                    if(input[i] > input[j] && LSI[i] < LSI[j]+1) {
                        LSI[i] = LSI[j] + 1;
                    }
                }
                if(max < LSI[i]) max = LSI[i];
            }

            System.out.println("#" + cycle + " " + max);


        }
    }
}
