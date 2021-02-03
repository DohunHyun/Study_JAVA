package SWEA2805;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int cycle=1; cycle<=testcase; cycle++) {
            int size = sc.nextInt();
            int[][] farm = new int[size][size];
            sc.nextLine();

            for(int i=0; i<size; i++) {
                String input = sc.nextLine();
                String[] inputArray = input.split("");
                for(int j=0; j<size; j++) {
                    farm[i][j] = Integer.parseInt(inputArray[j]);
                }
            }

            int mintemp = size/2; // 2 1 0
            int maxtemp = size/2; // 2 3 4
            int money = 0;
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(j>=mintemp && j<= maxtemp) {
                        money += farm[i][j];
                    }
                }
                if(i<size/2) {
                    mintemp--;
                    maxtemp++;
                } else {
                    mintemp++;
                    maxtemp--;
                }
            }

            System.out.println("#" + cycle + " " + money);
        }
    }
}
