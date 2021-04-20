package SWEA5604;

import java.util.Scanner;

public class Solution_구간합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for(int t=1; t<=TC; t++) {
            long A = sc.nextInt();
            long B = sc.nextInt();
            long size = B-A+1;
            long[] array = new long[(int)size];
            long temp = A;
            long answer = 0;

            for(int i=0; i<size; i++) {
                array[i] = temp++;
            }

            for(int i=0; i<size; i++) {
                long x = array[i];

                while (true) {
                    if(x/10 == 0) {
                        answer += x;
                        break;
                    }
                    else {
                        answer += x%10;
                        x = x/10;
                    }
                }
            }

            System.out.println("#" + t + " " + answer);


        }
    }
}
