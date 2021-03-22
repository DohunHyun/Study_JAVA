package JUNGOL1681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static int ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().substring(0,1));
        map = new int[N][N];
        ans = Integer.MAX_VALUE;
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0, 0);

        System.out.println(ans);
    }

    private static void find(int index, int count, int cost) {
        if(cost >= ans) return;

        if(count == N-1) { // 다 돌았다 fin.
            if(map[index][0] != 0) { // 사무실로 가는 방법이 있다!
                cost += map[index][0]; // 마지막에서 다시 사무실로 돌아오는!
            } else { // 가는 방법이 없다?! 그럼 망...
                return;
            }
            if(cost < ans) {
                ans = cost;
            }
            return;
        }

        for(int i=1; i<N; i++) {
            if(!visited[i] && map[index][i] != 0) {
                visited[i] = true;
                find(i, count+1, cost + map[index][i]);
                visited[i] = false;
            }
        }
    }
}
