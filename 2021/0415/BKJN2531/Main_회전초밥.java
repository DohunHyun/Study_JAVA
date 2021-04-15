package BKJN2531;

import java.util.Arrays;
import java.util.Scanner;

public class Main_회전초밥 {
    static int N;
    static int d;
    static int k;
    static int c;
    static int[] table;
    static boolean[] sushiKind;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        table = new int[N];
        sushiKind = new boolean[d + 1];

        for (int i = 0; i < N; i++) {
            table[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            Arrays.fill(sushiKind, false); // 초기화
            for (int j = i; j < (i + k); j++) {
                // 일단 종류별로 다 담고 세기
                if (!sushiKind[table[j % N]]) { // 아직 안먹은 초밥이면
                    sushiKind[table[j % N]] = true; // 담고
                    count++;

                    if (table[j % N] == c) count--;
                }

            }
            if (count == k + 1) {
                answer = count;
                break;
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }

}