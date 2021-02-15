package SWEA6808;

import java.util.Scanner;

public class Solution {
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle=1; cycle<=testcase; cycle++) {
            int[] deck = new int[19]; // 전체 카드 덱
            int[] input = new int[9]; // 규영이가 내는 카드 순서
            visited = new boolean[9];

            for(int i=0; i<9; i++) {
                input[i] = sc.nextInt();
                deck[input[i]] = 1; // 규영이 카드 표시
            }

            int[] G = new int[9];
            int[] I = new int[9];
            int g_size = 0;
            int i_size = 0;

            for(int i=0; i<19; i++) {
                if(deck[i] == 1) {
                    G[g_size++] = i;
                } else {
                    I[i_size++] = i;
                }
            }

            for(int i=1; i<10; i++) {
                dfs(i, 1);
            }
        }
    }

    private static void dfs(int x, int depth) {

        if(depth == 9) { // 다한거!
            // 점수 계산

        }

        for(int i=1; i<10; i++) {

        }
    }
}
