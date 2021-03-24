package BKJN1464;

import java.util.Arrays;
import java.util.Scanner;

public class Main_dp {
    static int N;
    static int ans;
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = 0;
        count = new int[N+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        count[1] = 0;

        for(int i=2; i<=N; i++) {
            if(i%6 == 0) {
                count[i] = Math.min(count[i]/3, count[i]/2) + 1;
            }
            if(i%3 == 0) {
                count[i] = Math.min(count[i], count[i/3] + 1);
            }
            if(i%2 == 0) {
                count[i] = Math.min(count[i], count[i/2] + 1);
            }
            count[i] = Math.min(count[i], count[i-1]+1);
        }

        System.out.println(count[N]);


    }
}
