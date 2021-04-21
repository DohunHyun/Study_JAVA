package BKJN15683;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_감시 {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};
    static int answer;
    static ArrayList<int[]> camera;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[][] map = new int[N][M];
        camera = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] > 0 && map[i][j] < 6) {
                    camera.add(new int[] {i,j});
                }
            }
        }

        if(camera.size() == 0) {
            answer = count(map);
        } else {
            answer = Integer.MAX_VALUE;
            dfs(0, map);
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int[][] prevMap) {
        if(index == camera.size()) {
            answer = Math.min(count(prevMap), answer);
            return;
        }

        int[] temp = camera.get(index); // 카메라 꺼내서
        int x = temp[0];
        int y = temp[1];

        for(int i=0; i<4; i++) { // 방향 바꿔가면서 카메라로 보기
            int[][] newMap = copy(prevMap);

            // 상우하좌
            if(newMap[x][y] == 1) {
                check(x,y,i, newMap);
            } else if(newMap[x][y] == 2) { // 상하, 좌우
                if(i == 0 || i==2) { // 상, 하 일때
                    check(x, y, 0, newMap); // 위로 체크
                    check(x, y, 2, newMap); // 아래로 체크
                } else if(i == 1 || i==3) { // 좌일때
                    check(x, y, 1, newMap); // 왼쪽 체크
                    check(x, y, 3, newMap); // 오른쪽 체크
                }
            } else if(newMap[x][y] == 3) { // 자기방향, 자기방향+1 만큼 체크
                // 상우, 우하, 하좌, 좌상
                check(x, y, i, newMap);
                if(i == 3) { // 마지막경우에는
                    check(x, y, 0, newMap); // 다시 첫번째로
                } else {
                    check(x, y, i+1, newMap);
                }
            } else if(newMap[x][y] == 4) { // 세방향
                check(x, y, i, newMap);
                if(i == 0) {
                    check(x, y, 3, newMap);
                    check(x, y, 1, newMap);
                } else if(i == 3) {
                    check(x, y, 2, newMap);
                    check(x, y, 0, newMap);
                } else {
                    check(x, y, i-1, newMap);
                    check(x, y, i+1, newMap);
                }
            } else if(newMap[x][y] == 5) {
                for(int j=0; j<4; j++)
                    check(x, y, j, newMap);
            }

            dfs(index+1, newMap);
        }
    }

    private static int[][] copy(int[][] prevMap) {
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = prevMap[i][j];
            }
        }
        return map;
    }

    private static int count(int[][] map) {
        int cnt=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    private static void check(int x, int y, int d, int[][] map) {

        int r = x + dr[d];
        int c = y + dc[d];
        if(!(r>=0 && r<N && c>=0 && c<M)) {
            return;
        }

        if(map[r][c] == 6) { // 벽 만나면 끝
            return;
        } else if(map[r][c] == 0) {
            map[r][c] = 7; // 보이는걸로 체크
        }
        check(r, c, d, map);
    }
}
