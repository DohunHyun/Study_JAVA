package SWEA5607;

import java.util.Scanner;

public class Solution_조합 {
    static int MOD = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] fact = new long[10000001];
        fact[0] = 1;
        for(int i=1; i<= 1000000; i++) {
            fact[i] = (fact[i-1]*i) % MOD;
        }

        int TC = sc.nextInt();

        for(int t=1; t<=TC; t++) {
            int N = sc.nextInt();
            int R = sc.nextInt();

//            int answer = 1;
//
//            int temp = N;
//
//            if(R==0) {
//                answer = N;
//            } else {
//                for(int i=0; i<R; i++) {
//                    answer *= temp;
//                    temp--;
//                }
//
//                temp = R;
//                for(int i=0; i<R; i++) {
//                    answer /= temp;
//                    temp--;
//                }
//
//                answer = answer % 1234567891;
//            }

            long up = fact[N]%MOD;
            long down = ((fact[N-R]%MOD) * (fact[R]%MOD))%MOD;
            long moveTop = pow(down, MOD-2);

            System.out.println("#" + t + " " + ((up*moveTop)%MOD));
        }
    }

    static long pow(long n, long r) {
        if(r == 0) return 1;
        else if(r == 1) return n;

        long temp = 0;
        if(r%2 == 0) {
            temp = pow(n, r/2) % MOD;
            return (temp*temp)%MOD;
        } else {
            temp = pow(n, r/2) % MOD;
            return (((temp*temp)%MOD)*n)%MOD;
        }
    }
}
