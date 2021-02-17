package BKJN1992;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] array;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        array = new int[N][N];

        sc.nextLine();
        for(int i=0; i<N; i++) {
            String input = sc.nextLine();
            String[] inputArray = input.split("");
            for(int j=0; j<N; j++) {
                array[i][j] = Integer.parseInt(inputArray[j]);
            }
        }

        check(0, 0, N);

        System.out.println(sb);
    }

    private static void check(int startI, int startJ, int size) {
        if(checkZero(startI, startJ, size)) { // 안에가 전부 0 일때
            sb.append("0");
            return;
        } else if(checkOne(startI, startJ, size)) { // 안에가 전부 1일때
            sb.append("1");
            return;
        }

        sb.append("(");
        check(startI, startJ, size/2); // 왼쪽위
        check(startI, startJ + size/2, size/2); // 오른쪽위
        check(startI+size/2, startJ, size/2);
        check(startI+size/2, startJ+size/2, size/2);
        sb.append(")");


    }

    private static boolean checkZero(int startI, int startJ, int size) {
        for(int i=startI; i<startI+size; i++) {
            for(int j=startJ; j<startJ+size; j++) {
                if(array[i][j] != 0) return false;
            }
        }
        return true;
    }

    private static boolean checkOne(int startI, int startJ, int size) {
        for(int i=startI; i<startI+size; i++) {
            for(int j=startJ; j<startJ+size; j++) {
                if(array[i][j] != 1) return false;
            }
        }
        return true;
    }
}
