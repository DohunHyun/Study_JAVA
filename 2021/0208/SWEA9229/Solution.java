package SWEA9229;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int cycle=1; cycle<=testcase; cycle++) {
            int N = sc.nextInt(); // 과자 봉지 수
            int M = sc.nextInt(); // 무게 제한
            int[] weight = new int[N];

            for(int i=0; i<N; i++) {
                weight[i] = sc.nextInt();
            }

            int max = -1;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) {

                    } else if(weight[i] + weight[j] <= M){
                        if(max < weight[i] + weight[j]) {
                            max = weight[i] + weight[j];
                        }
                    }
                }
            }

            System.out.println("#" + cycle + " " + max);

        }
    }
}
