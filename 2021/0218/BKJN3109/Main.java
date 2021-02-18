package BKJN3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, cnt;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        makePipe();
        System.out.println(cnt);
    }

    private static void makePipe() {
        cnt = 0;
        for(int i=0; i<R; i++) { // 윗행부터 시도
            visited[i][0] = true;
            dfs(i, 0);

        }
    }

    static int[] dr = {-1, 0, 1}; // 오른쪽위, 오른쪽, 오른쪽아래 이동할때 행 변화

    private static boolean dfs(int r, int c) {

        if(c == C-1) { // 파이프가 가장 끝까지 갔을경우
            cnt++;
            return true; // 파이프 놓기 성공
        }

        int nr, nc = c+1; // nc는 오른쪽 열, nr은 오른쪽 행
        for(int d=0; d<3; d++) { //
            nr = r + dr[d];
            if(nr<0 || nr >= R || map[nr][nc] == 'X' || visited[nr][nc]) continue; // 탐색 불가한 경우

            visited[nr][nc] = true;
            if(dfs(nr, nc)) return true;
//            visited[nr][nc] = false;
// 실패했던 흔적 되돌리지 않기. 뒤 선택지의 방향은 현재보다 유리하지 않은 상황이고 결국 같은 상황이 반복된다.
        }

        return false;
    }
}
