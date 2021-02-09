package BKJN2563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paperNum = sc.nextInt();

        int[][] white = new int[100][100];
        int answer = 0;

        for(int cycle=1; cycle<=paperNum; cycle++) {
            int left = sc.nextInt();
            int bottom = sc.nextInt();

            for(int i=left; i<left+10; i++) {
                for(int j=bottom; j<bottom+10; j++) {
                    if(white[i][j] == 0) {
                        white[i][j] = 1;
                        answer++;
                    }
                }
            }

        }
        System.out.println(answer);
    }
}
