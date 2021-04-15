package SWEA1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_탈주범검거DFS {
    static int N, M, R, C, L;
    static int[][] map;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] visited;
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
            visited = new int[N][M];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }
            dfs(R, C, 1); // 도망가!
            System.out.println("#" + t + " " + getCount());
        }
    }

    private static int getCount() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] != Integer.MAX_VALUE) count++;
            }
        }
        return count;
    }

    private static void dfs(int r, int c, int time) {
        visited[r][c] = time;
        if(time == L) return;

        String shape = style[map[r][c]];

        for(int d=0; d<shape.length(); d++) {
            int dir = shape.charAt(d) - '0';
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr>=0 && nr<N && nc>=0 && nc<M
                    && map[nr][nc] > 0
                    && style[map[nr][nc]].contains(Integer.toString(3-dir))
                    && visited[nr][nc] > time) {
                dfs(nr, nc, time+1);
            }
        }
    }
}