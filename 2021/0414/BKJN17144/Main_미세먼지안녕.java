package BKJN17144;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_미세먼지안녕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); // row
        int C = sc.nextInt(); // column
        int T = sc.nextInt(); // time
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int air = 0;

        int[][] room = new int[R][C];
        int result = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                room[i][j] = sc.nextInt();
                if(room[i][j] == -1) {
                    air = i; // i행 0열 청정기 위치. (i,0), (i-1, 0)
                }
            }
        }

        int time = T;
        while (time>0) {
            time--;

            // 먼지 확산
            Queue<int[]> queue = new LinkedList<>(); // 동시에 일어나기 때문에 큐 사용
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(room[i][j] > 0) {
                        queue.add(new int[] {i,j}); // 먼지 있는곳 큐에 넣고
                    }
                }
            }

            while(!queue.isEmpty()) { // 한번에 들어온애들 다 처리해주기.
                int[] dust = queue.poll();
                int x = dust[0];
                int y = dust[1];
                int count=0;
                for(int i=0; i<4; i++) { // 확산 가능한 방향 세기
                    int rr = x + dr[i];
                    int cc = y + dc[i];
                    if(rr>=0 && rr<R && cc>=0 && cc<C && room[rr][cc] != -1) {
                        room[rr][cc] += room[x][y] / 5;
                        count++; // 갈 수 있으면 방향 세고
                    }
                }
                room[x][y] = room[x][y] - ( (room[x][y] / 5) * count );
                // 기존에 있던 먼지 위치에 확산 후 양으로 갱신

            }


            // 공기청정기 이동
            // 상단은 반시계방향, R = air-1
            int x = air-1; // 행
            int y = 1; // 열
            int temp = room[x][y]; // 다음 이동할 곳의 먼지
            while(temp != -1) {
                if(x == 0) { // 맨 위, 왼쪽으로 진행
                    temp = room[x-1][y];
                }
                if(y == C-1) { // 오른쪽 끝, 위로 올라가기
                    temp = room[x][y-1]; // 다음거 저장하고
                }

                room[x][y+1] = room[x][y]; // 다음거에 지금거 넣고
                if(room[x][y-1] == -1) { // 이전거가 공기청정기면
                    room[x][y] = 0; // 0이 나오고
                } else { // 아니면 그냥 이동. 지금 위치에 이전거 넣기.
                    room[x][y] = room[x][y-1];
                }


            }

            // 하단은 시계방향, R = air

        }





        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                result += room[i][j];
            }
        }
        System.out.println(result);
    }
}
