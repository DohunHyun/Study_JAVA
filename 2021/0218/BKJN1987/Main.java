package BKJN1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        char[] list;
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            list = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                map[i][j] = list[j];
            }
        }
        
        visited = new boolean[26];
        dfs(0,0,1);

        System.out.println(max);

    }

    private static void dfs(int x, int y, int count) {

        visited[map[x][y] - 'A'] = true; // 현재 상황에서 방문했다고 체크하고 진행
        for(int i=0; i<4; i++) { // 4방향 탐색
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx>=0 && xx<R && yy>=0 && yy < C) { // 이동가능한 부분이고
                if(!visited[map[xx][yy] - 'A']) { // 만약 아직 안갔었으면
                    dfs(xx, yy, count+1);
                }
            }
        }
        visited[map[x][y] - 'A'] = false; // 모든 방향 다 하고 다시 방문 안한것으로 체크

        if(max < count) max = count;
    }
}
