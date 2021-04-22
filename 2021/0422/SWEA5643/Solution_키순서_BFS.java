package SWEA5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서_BFS {
    static int N, M;
    static int[][] adj;
    static int gtCnt, ltCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N+1][N+1];

            StringTokenizer st = null;
            int i, j;
            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                adj[i][j] = 1; // i는 j보다 키가 작다.
            }

            int ans = 0;
            for(int k=1; k<=N; k++) {
                gtCnt = ltCnt = 0;
                gtBFS(k, new boolean[N+1]);
                ltBFS(k, new boolean[N+1]);
                if(gtCnt + ltCnt == N-1){
                    ans++;
                }
            }

            System.out.println("#" + t + " " + ans);



        }


    }

    private static void gtBFS(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int i=1; i<=N; i++) {
                if(!visited[i] && adj[k][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    gtCnt++;
                }
            }
        }
    }

    private static void ltBFS(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int i=1; i<=N; i++) {
                if(!visited[i] && adj[i][k] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    ltCnt++;
                }
            }
        }
    }


}
