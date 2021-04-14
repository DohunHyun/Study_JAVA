package SWEA5656;

import java.util.Scanner;

public class Solution_벽돌깨기 {
    static int N;
    static int W, H;
    static int[][] map;
    static int remain;
    static int total;
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int cycle = 1; cycle <= T; cycle++) {
            answer = 0;

            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            map = new int[H][W];
            total = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] > 0) total++;
                }
            }

            remain = total;

            if (total <= N) {
                System.out.println("#" + cycle + " " + 0);
                continue;
            }
            dfs(0);
            System.out.println("#" + cycle + " " + answer);
        }
    }

    private static void dfs(int cnt) {
        if (remain == 0) { // 남은게 0개다
            answer = 0;
            return;
        }

        if (cnt == N) { // 기회 다 썼다

            return;
        }

        for (int i = 0; i < W; i++) {
            int r = 0; // 벽돌이 있는 위치 찾기. 가장 위에 벽돌
            while (true) {
                if (map[r][i] == 0) {
                    break;
                }
                r++;
                if (r == H) break; // 끝까지 갔는데 없으면 끝
            }
            if (r == H) continue;
        }

    }

    static void crash() {
        for (int m = 0; m < N; m++) {

        }
    }

    private static class Point {
        public Point(int i, int next, Object p2) {
        }
    }
}
