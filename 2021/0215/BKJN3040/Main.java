package BKJN3040;

import java.util.Scanner;

public class Main {
    static int[] real;
    static boolean[] visited;
    static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new int[9]; // 입력받은 9명의 난쟁이들의 값
        visited = new boolean[9]; // 난쟁이들 선택 여부
        real = new int[7]; // 선택받는 7명의 난쟁이 값

        for(int i=0; i<9; i++) {
            list[i] = sc.nextInt();
        }

        check(0, 0, 0);
    }

    private static void check(int num, int amount, int start) {
        if(num == 7) { // 끝나는 조건. 난쟁이 7명을 다 고르면.
            if(amount == 100) {
                for(int t : real) {
                    System.out.println(list[t]);
                }
            }
            return;
        }

        for(int i=start; i<9; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
                real[num] = i;
                check(num+1, amount+list[i] ,i+1 );
//                visited[i] = false;
//            }
        }




    }
}
