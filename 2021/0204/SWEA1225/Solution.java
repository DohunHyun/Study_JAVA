package SWEA1225;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int cycle=1; cycle<=10; cycle++) {
            int[] password = new int[8];
            int testcase = sc.nextInt();

            for(int i=0; i<8; i++) {
                password[i] = sc.nextInt();
            }

            int decrese = 1;
            boolean breakpoint = true;
            while(breakpoint) {
                if(decrese>5) decrese = 1;
                password[0] -= decrese++;
                int temp = password[0];
                for(int i=0; i<7; i++) {
                    password[i] = password[i+1];
                }
                password[7] = temp;

                if(password[7] <= 0) {
                    password[7] = 0;
                    breakpoint = false;
                }
            }

            System.out.print("#" + testcase + " ");
            for(int i=0; i<password.length; i++) {
                System.out.print(password[i] + " ");
            }
            System.out.println();
        }
    }
}
