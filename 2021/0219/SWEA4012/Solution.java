package SWEA4012;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution { // 요리사
    static int[][] ingredients;
    static boolean[] used;
    static int N;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for(int cycle=1; cycle<=testcase; cycle++) {
            N = sc.nextInt();

            ingredients = new int[N][N];
            used = new boolean[N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    ingredients[i][j] = sc.nextInt();
                }
            }

            answer = Integer.MAX_VALUE;
            comb(0, 0);
            System.out.println("#" + cycle + " " + answer);
        }

    }

    private static void comb(int index, int count) {
        if(count == N/2) { // 재료 다 고르면 계산 시작
            ArrayList<Integer> foodA = new ArrayList<>();
            ArrayList<Integer> foodB = new ArrayList<>();

            for(int i=0; i<N; i++) {
                if (used[i]) foodA.add(i);
                else foodB.add(i);
            }
            int tempA=0;
            int tempB=0;
            for(int i=0; i<N/2; i++) {
                for(int j=0; j<N/2; j++) {
                    if(i != j) {
                        tempA += ingredients[foodA.get(i)][foodA.get(j)];
                        tempB += ingredients[foodB.get(i)][foodB.get(j)];
                    }
                }
            }
            answer = Math.min(Math.abs(tempA - tempB), answer);
            return;
        }
        if(index == N-1) return;

        used[index] = true;
        comb(index+1, count+1);
        used[index] = false;
        comb(index+1, count);
    }
}
