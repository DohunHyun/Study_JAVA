package SWEA1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_파핑파핑지뢰찾기 {
    static int N;
    static String[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 시계방향
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int t=1; t<=TC; t++) {
            N = Integer.parseInt(br.readLine());

            map = new String[N][N];
            visited = new boolean[N][N];
            answer = 0;

            for(int i=0; i<N; i++) {
                map[i] = br.readLine().split("");
            }

            // 최소로 클릭해서 다 알아야함.
            // 주변에 아무것도 없는 애들을 미리 클릭해서 싹 열고
            // 사이사이 클릭해야함.

            // 주변에 지뢰가 없는애들을 찾아서 다 눌러.
            // 그애 주변에 애 한테도 주변에 지뢰가 없다면 걔네도 다 열어
            // 그때 카운트 1++
            // 그렇게 다 주변에 없는애들 다 열면
            // 나머지 애들은 주변에 지뢰가 있으니까 그냥 카운트

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && check(i,j)) { // 주변에 지뢰 없는지 체크
                        // 지뢰 없으면 주변에 자기처럼 지뢰없는애들 다 찾아서 오픈.
                        open(i, j);
                    }
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && !map[i][j].equals("*")) {
                        answer++;
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }

    private static void open(int x, int y) { // 주변에 애들중 지뢰 없는애들 싹다 오픈
        answer++; // open 하면 클릭 수 증가
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0; i<8; i++) {
                int rr = temp[0] + dr[i];
                int cc = temp[1] + dc[i];
                if(inRange(rr, cc)) {
                    if (!visited[rr][cc] && check(rr, cc)) { // 주변에 있는 애가 그 주변에 지뢰가 없다면
                        queue.offer(new int[]{rr, cc});
                        visited[rr][cc] = true;
                    } else { // 그 주변 애가 주변에 지뢰가 있다면?
                        // 주변 지뢰 수 카운트해서 숫자 입력하고 방문처리.
                        visited[rr][cc] = true;
                    }
                }
            }
        }
    }

    private static boolean check(int x, int y) { // 주변에 지뢰 있나 체크
        for(int i=0; i<8; i++) {
            int rr = x+dr[i];
            int cc = y+dc[i];
            if(inRange(rr, cc) && map[rr][cc].equals("*")) return false; // 지뢰 있으면 false
        }

        return true; // 지뢰 없으면 true
    }

    private static boolean inRange(int rr, int cc) {
        if(rr>=0 && rr<N && cc>=0 && cc<N) return true;
        return false;
    }
}
