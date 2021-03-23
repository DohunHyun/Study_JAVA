package BKJN1149;

import java.util.Scanner;

public class Main { // 1149. RGB거리 dfs풀이. 실패!
    static int N;
    static int[][] cost;
    static int ans;
//    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N][3];
        ans = Integer.MAX_VALUE;
//        visited = new int[N]; // 0:빨강, 1:초록, 2:파랑

        for(int i=0; i<N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        for(int i=0; i<3; i++) {
            dfs(0, i, cost[0][i]);
        }

        System.out.println(ans);
    }

    private static void dfs(int index, int beforecolor, int sum) {
        if(sum >= ans) return;

        if(index == N-1) { //
            if(sum < ans) ans = sum;
            return;
        }

        for(int i=0; i<3; i++) {
            if(i != beforecolor) {
                dfs(index+1, i, sum + cost[index+1][i]);
            }
        }







//        if(beforecolor == 0) { // 초기값. 색칠 시작!
//            visited[index] = 1;
//            dfs(index+1, 1, sum + cost[index][0]);
//            visited[index] = 2;
//            dfs(index+1, 2, sum + cost[index][1]);
//            visited[index] = 3;
//            dfs(index+1, 3, sum + cost[index][2]);
//        } else
//            if(beforecolor == 1) { // 전에가 1번색이다
//            visited[index] = 2;
//            dfs(index+1, 2, sum + cost[index][1]);
//            visited[index] = 3;
//            dfs(index+1, 3, sum + cost[index][2]);
//        } else if(beforecolor == 2) {
//            visited[index] = 1;
//            dfs(index+1, 1, sum + cost[index][0]);
//            visited[index] = 3;
//            dfs(index+1, 3, sum + cost[index][2]);
//        } else if(beforecolor == 3) {
//            visited[index] = 1;
//            dfs(index+1, 1, sum + cost[index][0]);
//            visited[index] = 2;
//            dfs(index+1, 2, sum + cost[index][1]);
//        }





    }
}
