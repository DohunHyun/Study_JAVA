package BKJN1149;

import java.util.Scanner;

public class Main_dp { // 1149 rgb거리. dp풀이
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] cost,total;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N][3];
        total = new int[N][3];

        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // 초기값 설정. 각 색을 선택 했을때!
        total[0][0] = cost[0][0];
        total[0][1] = cost[0][1];
        total[0][2] = cost[0][2];

        for(int i=1; i<N; i++) {
            total[i][0] = Math.min(total[i-1][1], total[i-1][2]) + cost[i][0];
            total[i][1] = Math.min(total[i-1][0], total[i-1][2]) + cost[i][1];
            total[i][2] = Math.min(total[i-1][0], total[i-1][1]) + cost[i][2];
        }

        ans = Math.min(total[N-1][0], Math.min(total[N-1][1],total[N-1][2]));
        System.out.println(ans);

    }
}
