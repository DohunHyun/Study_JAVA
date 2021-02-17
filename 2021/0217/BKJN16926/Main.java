package BKJN16926;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 행
        M = sc.nextInt(); // 열
        int R = sc.nextInt(); // 회전수

        int[][] array = new int[N][M];

        for(int i=0; i<N; i++) { // 배열 입력받기
            for(int j=0; j<M; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for(int s=0; s<R; s++) {
            rotate(array);
        }

        for(int i=0; i<N; i++) { // 배열 입력받기
            for(int j=0; j<M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void rotate(int[][] array) {
        int si=0, sj=0;
        int ei=N, ej=M;

        while (true) {
            if(ei-si <=1 || ej-sj<=1) {
                break;
            }

            int tmp = array[si][sj];

            for(int j=sj+1; j<ej; j++) { // 윗줄 왼쪽으로 한칸씩 <-
                array[si][j-1] = array[si][j];
            }

            for(int i=si+1; i<ei; i++) { // 오른쪽줄 위로 한칸씩
                array[i-1][ej-1] = array[i][ej-1];
            }

            for(int j=ej-1; j>sj; j--) { // 맨밑줄 오른쪽으로 ->
                array[ei-1][j] = array[ei-1][j-1];
            }

            for(int i=ei-1; i>si+1; i--) {
                array[i][sj] = array[i-1][sj];
            }

            array[si+1][sj] = tmp;

            si++;
            sj++;
            ei--;
            ej--;
        }
    }

}
