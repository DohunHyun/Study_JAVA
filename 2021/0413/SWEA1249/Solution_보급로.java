package SWEA1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_보급로 {
    static int N;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int cycle=1; cycle<=TC; cycle++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0; i<N; i++) {
                char[] ch = br.readLine().toCharArray();
                for(int j=0; j<N; j++) {
                    map[i][j] = ch[j] - '0';
                }
            }
            System.out.println("#" + cycle + " " + dijkstra(0,0));
        }
    }

    private static int dijkstra(int startR, int startC) {

        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[startR][startC] = 0;

        int x=0, y=0, cost=0, xx, yy;
        while (true) { // 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택


            cost = INF;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && cost > minTime[i][j]) {
                        cost = minTime[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            if(x == N-1 && y == N-1) {
                return cost;
            }

            visited[x][y] = true;
            // 가장 가까운 다음 정점.
            // 선택된 기준으로 인접한 정점 중에 방문하지 않은 다른정점 갱신.
            // 선택된 기준을 통해서 갈때와 기존값중 작은 값으로 갱신.

            // 현재 위치 기준으로 4방 탐색
            for (int d=0; d<4; d++) {
                xx = x + dx[d];
                yy = y + dy[d];
                if(xx>=0 && xx<N && yy>=0 && yy<N && !visited[xx][yy]
                        && minTime[xx][yy] > cost + map[xx][yy]) {
                    minTime[xx][yy] = cost + map[xx][yy];
                }
            }
        }
    }

    private static int dijkstraPQ(int startR, int startC) {

        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                minTime[i][j] = INF;
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // 정점의 위치, 출발지 ~ cost

        minTime[startR][startC] = 0;
        queue.offer(new int[] {startR, startC, minTime[startR][startC]});

        int x=0, y=0, cost=0, xx, yy;
        int[] current;
        while (true) { // 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            current = queue.poll();
            x = current[0];
            y = current[1];
            cost = current[2];

            if(x == N-1 && y == N-1) {
                return cost;
            }

            if(visited[x][y]) { // 이미 처리된. 즉 이전에 수정된 더 적은 값이 처리됨.
                continue;
            }
            visited[x][y] = true;
            // 가장 가까운 다음 정점.
            // 선택된 기준으로 인접한 정점 중에 방문하지 않은 다른정점 갱신.
            // 선택된 기준을 통해서 갈때와 기존값중 작은 값으로 갱신.

            // 현재 위치 기준으로 4방 탐색
            for (int d=0; d<4; d++) {
                xx = x + dx[d];
                yy = y + dy[d];
                if(xx>=0 && xx<N && yy>=0 && yy<N && !visited[xx][yy]
                        && minTime[xx][yy] > cost + map[xx][yy]) {
                    minTime[xx][yy] = cost + map[xx][yy];
                    queue.offer(new int[] {xx, yy, minTime[xx][yy]});
                }
            }
        }
    }
}
