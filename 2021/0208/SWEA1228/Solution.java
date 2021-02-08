package SWEA1228;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int cycle = 1; cycle<=10; cycle++) {
            int length = sc.nextInt();
            LinkedList<Integer> password = new LinkedList<>();

            for(int i=0; i<length; i++) { // 기존 암호문 넣어주기
                password.add(sc.nextInt());
            }

            int inputLength = sc.nextInt();
            for(int i=0; i<inputLength; i++) { // 새로 삽입
                String inputCommand = sc.next();
                int start = sc.nextInt();
                int amount = sc.nextInt();
                for(int j=0; j<amount; j++) {
                    password.add(start+j, sc.nextInt());
                }
            }

            System.out.println("#" + cycle + " ");
            for(int i=0; i<10; i++) {
                System.out.print(password.poll() + " ");
            }

        }

    }
}
