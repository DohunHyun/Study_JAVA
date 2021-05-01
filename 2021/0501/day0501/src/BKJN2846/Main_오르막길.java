package BKJN2846;

import java.util.Scanner;

public class Main_오르막길 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] map = new int[N];

        for(int i=0; i<N; i++) {
            map[i] = sc.nextInt();
        }

        int max = 0; // 최대 오르막 크기
        int l = 0; // 지금 오르막 길이
        int first = map[0]; // 시작점 높이
        int size = 1;
        int temp = map[0]; // 바로 전 높이
        for(int i=1; i<=N; i++) {
            if(i == N) {
                if(size >= 2) {
                    max = Math.max(max, temp-first);
                }
                break;
            }
            if(map[i] > temp) {
                size++;
            } else {
                if(size >= 2) {
                    max = Math.max(max, temp-first);
                }
                first = map[i];
                size = 1;
            }
            temp = map[i];
        }

        System.out.println(max);


    }
}
