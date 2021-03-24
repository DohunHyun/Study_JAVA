package BKJN2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static int ans;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans = 0;
        map = new int[N][M];


        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time=0;

        while(!allZero()) {
            bfs(0,0); // 0,0에서 시작해서 인접하는 치즈 찾기
            int melted = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == 2) {
                        map[i][j] = 0;
                        melted++;
                    }
                }
            }
            time++;
            ans = melted;
        }

        System.out.println(time);
        System.out.println(ans);
    }

    private static void bfs(int i, int i1) {
        visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point air = queue.poll();

            for(int d=0; d<4; d++) {
                int ni = air.i + dx[d];
                int nj = air.j + dy[d];

                if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj] == 0 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.add(new Point(ni,nj));
                } else if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj] == 1) {
                    map[ni][nj] = 2; // 다음턴에 녹을 치즈
                }
            }
        }

    }

    private static boolean allZero() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) return false; // 아직 남아있다!
            }
        }
        return true;
    }

    private static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
