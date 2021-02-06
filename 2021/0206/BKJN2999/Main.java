package BKJN2999;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] inputArray = input.split("");

        int size = input.length();
        int C = 1; // 열
        int R = 0; // 행  && R<=C
        for(int i=1; i<=size/2; i++) {
            if(size%i == 0 && i>R && size/i >= i) {
                C = size/i;
                R = i;
            }
        }

        String[][] password = new String[R][C];
        int inputtemp = 0;

        for(int i=0; i<password[0].length; i++) { // 열부터 채우고 다음행으로
            for(int j=0; j<password.length; j++) {
                password[j][i] = inputArray[inputtemp];
                inputtemp++;
            }
        }

        String output = "";
        for(int i=0; i<password.length; i++) { // 하나의 행부터 읽고 다음 행으로
            for(int j=0; j<password[0].length; j++) {
                output += password[i][j];
            }
        }

        System.out.println(output);
    }
}
