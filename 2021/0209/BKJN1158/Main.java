package BKJN1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> list = new LinkedList();

        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        while(!list.isEmpty()) {
            for(int i=0; i<K; i++) {
                if(i == K-1) {
                    sb.append(list.poll() + ", ");
                } else {
                    list.add(list.poll());
                }
            }
        }

        System.out.println("<" + sb.substring(0, sb.length()-2) + ">");


    }
}
