package SWEA4789;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        sc.nextLine();

        for(int cycle=1; cycle<=testcase; cycle++) {
            String input = sc.nextLine();
            String[] inputarray = input.split("");
            int[] array = new int[inputarray.length];

            for(int i=0; i<inputarray.length; i++) {
                array[i] = Integer.parseInt(inputarray[i]);
            }

            int clap = 0;
            int hire = 0;

            for(int i=0; i<array.length; i++) {
                if(clap >= i) {
                    clap += array[i];
                } else {
                    hire += i - clap;
//                    clap += hire + array[i]; // 이건 왜 안될까 ...?
                    clap = i + array[i];
                }
            }

            System.out.println("#" + cycle + " " + hire);

        }
    }
}
