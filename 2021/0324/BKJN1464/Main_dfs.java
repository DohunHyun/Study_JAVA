package BKJN1464;

import java.util.Scanner;

public class Main_dfs  {
    static int N;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = Integer.MAX_VALUE;

        dfs(N, 0);
        System.out.println(ans);

    }

    private static void dfs(int n, int cnt) {
        if(cnt >= ans) return;
        if(n == 1) {
            if(ans > cnt) ans = cnt;
            return;
        }

        if(n%6 == 0) {
            dfs(n/2, cnt+1);
            dfs(n/3, cnt+1);
        }
        else if(n%3 == 0) {
            dfs(n/3, cnt+1);
        }
        else if(n%2 == 0) {
            dfs(n/2, cnt+1);
        }
        dfs(n-1, cnt+1);
    }
}
