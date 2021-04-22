package SWEA5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서_DFS {
    static int N, M;
    static int[][] adj, radj;
    static int gtCnt, ltCnt, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N+1][N+1];
            radj = new int[N+1][N+1];

            StringTokenizer st = null;
            int i, j;
            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                adj[i][j] = 1; // i는 j보다 키가 작다.
                radj[j][i] = 1;
            }

            int ans = 0;
            int answer = 0;
            for(int k=1; k<=N; k++) {
                gtCnt = ltCnt = 0;
                gtDFS(k, new boolean[N+1]);
                ltDFS(k, new boolean[N+1]);
                if(gtCnt + ltCnt == N-1){
                    ans++;
                }

                cnt=0;
                dfs(k, adj, new boolean[N+1]);
                dfs(k, radj, new boolean[N+1]);
                if(cnt == N-1) answer++;
            }

            System.out.println("#" + t + " " + ans);
            System.out.println("#" + t + " " + answer);



        }


    }

    private static void gtDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int i=1; i<=N; i++) {
            if (!visited[i] && adj[cur][i] == 1) {
                gtDFS(i, visited);
                gtCnt++;
            }
        }
    }

    private static void ltDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int i=1; i<=N; i++) {
            if (!visited[i] && adj[i][cur] == 1) {
                ltDFS(i, visited);
                ltCnt++;
            }
        }
    }

    private static void dfs(int cur, int[][] adj, boolean[] visited) {
        visited[cur] = true;
        for(int i=1; i<=N; i++) {
            if(!visited[cur] && adj[cur][i]==1) {
                dfs(i, adj, visited);
                cnt++;
            }
        }

    }


}
