package SWEA1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_보급로 {
    static int T, N;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 1}; // 하우
//    static int[] dy = {1, 0};
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int cycle=1; cycle<=T; cycle++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            answer = Integer.MAX_VALUE;
            ans = new int[N][N];
            for(int i=0; i<N; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;

            for(int i=0; i<N; i++) {
                String[] temp = br.readLine().split("");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }

            visited[0][0] = true;
//            findRoute(0, 0, 0);
            findRouteBFS(0, 0);

            System.out.println("#" + cycle + " " + answer);
        }

        br.close();
    }

    private static void findRouteBFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            int a = temp.x;
            int b = temp.y;

            if(a == N-1 && b == N-1) {
                answer = Math.min(answer, ans[N-1][N-1]);
            }
            if(answer <= ans[a][b]) {
                continue;
            }

            for(int i=0; i<dx.length; i++) {
                int xx = a+dx[i];
                int yy = b+dy[i];

                if(xx>=0 && xx<N && yy>=0 && yy<N &&
                        (!visited[xx][yy] || ans[xx][yy] > ans[a][b] + map[xx][yy]) ) {
                    visited[xx][yy] = true;
                    ans[xx][yy] = ans[a][b] + map[xx][yy];
                    queue.add(new Node(xx, yy));
                }

            }
        }
    }

    private static void findRoute(int x, int y, int sum) {
        if(sum >= answer) {
            return;
        }

        if(x == N-1 && y == N-1) {
            answer = Math.min(sum, answer);
            return;
        }

        for(int i=0; i<dx.length; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];

            if(xx >= 0 && xx<N && yy>=0 && yy<N && !visited[xx][yy]) {
                visited[xx][yy] = true;
                findRoute(xx, yy, sum+map[xx][yy]);
                visited[xx][yy] = false;
            }

        }


    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
