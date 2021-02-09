package SWEA1233;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sentence;

        for(int cycle=1; cycle<=10; cycle++) {
            int size = sc.nextInt();

            for(int i=0; i<size; i++) {
                String input = sc.nextLine();
                sentence = input.split(" ");
                int possible = 1;

                if(sentence[1].equals("+") || sentence[1].equals("-")
                        || sentence[1].equals("*") || sentence[1].equals("/")) {
                    if(sentence.length == 4) { // 피연산자 2개까지 포함

                    } else { // 피연산자 없으면
                        possible = 0;
                        break;
                    }
                } else {
                    if(sentence.length > 2) {
                        possible = 0;
                        break;
                    }
                }
                System.out.println("#" + cycle + " " + possible);

            }



        }

    }
}

