package SWEA1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution { // 프로세스 연결하기
    static int N;
    static int[][] map;
    static ArrayList<int[]> list;
    static int max;
    static int min;
    static int totalCnt;
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(in.readLine());
        for(int tc=1; tc<= TC; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            list = new ArrayList<int[]>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i==0 || j==0 || i==N-1 || j==N-1) continue; // 가장자리는 무시
                    if(map[i][j]==1) { // 가장자리가 아닌 곳에 코어가 있는 경우
                        list.add(new int[] {i, j});
                        totalCnt++;
                    }
                }
            }

            go(0,0);
            System.out.println("#" + tc + " " + min);
        }
    }

    private static void go(int index, int cCnt) {
        // index : 부분집합에 고려할 코어 인덱스, cCnt : 연결된 코어 개수

        if(index == totalCnt) {
            int res = getLength();

            if(max < cCnt) {
                max = cCnt;
                min = res;
            } else if(max == cCnt) {
                if(res < min) {
                    min = res;
                }
            }

            return;
        }

        // 코어 선택해서 전선 놓아보기
        int[] cur = list.get(index);
        int r = cur[0];
        int c = cur[1];
        for(int d=0; d<4; d++) {
            if(isAvailable(r,c,d)) {
                //전선 놓기
                setStatus(r, c, d, 2);
                //다음 코어로 넘어가기
                go(index+1, cCnt+1);

                // 놓았던 전선 되돌려 놓기
                setStatus(r,c,d,0);
            }

        }

        //코어 비선택
        go(index+1, cCnt);
    }

    private static int getLength() {
        int lCnt=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 2) lCnt++;
            }
        }
        return lCnt;
    }

    private static void setStatus(int r, int c, int d, int s) {
        int nr=r, nc=c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if(nr<0 || nr>=N || nc<0 || nc>=N) break;
            map[nr][nc] = s;

        }
    }

    private static boolean isAvailable(int r, int c, int d) {
        int nr=r, nc=c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if(nr<0 || nr>=N || nc<0 || nc>=N) break;
            // 계속 방향으로 직진해서 경계를 벗어남. 전원연결 가능.

            if(map[nr][nc] >= 1) return false; // 진행불가. 코어나 다른 전선이 있는 경우
        }
        return true;
    }
}
