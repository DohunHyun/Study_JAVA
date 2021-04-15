package SWEA1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_탈주범검거 {
    static int N, M, R, C, L;
    static int[][] map;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int answer;
    static boolean[][] visited;
    static String[] style ={
            null,
            "0312",
            "03",
            "12",
            "02",
            "32",
            "31",
            "01"
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 세로
            M = Integer.parseInt(st.nextToken()); // 가로
            R = Integer.parseInt(st.nextToken()); // 맨홀 세로
            C = Integer.parseInt(st.nextToken()); // 맨홀 가로
            L = Integer.parseInt(st.nextToken()); // 시간

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            time = 1;
            run(); // 도망가!
            System.out.println("#" + t + " " + answer);
        }
    }

    private static void run() {
        int time = 1;
        int result = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(R, C, map[R][C]));
        visited[R][C] = true;
        ++result;

        while(time++ < L) {
            int size = queue.size(); // 동시간대에 들어온 애들만 체크
            while (size-- > 0) { // 동시간대 처리
                Point p = queue.poll();
                String shape = style[p.shape];

                for(int d=0; d<shape.length(); d++) {
                    int dir = shape.charAt(d) - '0';
                    int nr = p.r + dr[dir];
                    int nc = p.c + dc[dir];
                    if(nr>=0 && nr<N && nc>=0 && nc<M
                            && map[nr][nc] > 0
                            && style[map[nr][nc]].contains(Integer.toString(3-dir))
                            && !visited[nr][nc]) {
                        queue.offer(new Point(nr, nc, map[nr][nc]));
                        visited[nr][nc] = true;
                        ++result;
                    }
                }
            }
        }
        answer = result;
    }

    private static class Point {
        int r, c, shape;

        Point(int r, int c, int shape) {
            this.r = r;
            this.c = c;
            this.shape = shape;
        }
    }
}
