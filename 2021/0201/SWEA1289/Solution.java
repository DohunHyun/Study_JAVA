package SWEA1289;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count;

        for(int i=0; i<number; i++) {
            count = 0;
            String answer = sc.next();
            char[] sentence = new char[answer.length()];

            for(int j=0; j<answer.length(); j++) {
                sentence[j] = '0';
            }

            for(int k=0; k<answer.length(); k++) {
                if(sentence[k] == answer.charAt(k)) {

                } else { // 다르면
                    char temp = sentence[k];
                    for(int m=k; m<answer.length(); m++) {
                        if(temp == '0') {
                            sentence[m] = '1';
                        } else {
                            sentence[m] = '0';
                        }
                    }
                    count++;
                }
            }
            System.out.println("#" + (i+1) + " " + count);
        }
    }
}
