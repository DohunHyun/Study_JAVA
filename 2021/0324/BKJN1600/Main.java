package BKJN1600;

import java.util.Scanner;

public class Main {
    static int K;
    static int W, H;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        map = new int[H][W];

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                map[H][W] = sc.nextInt();
            }
        }

//        bfs();


    }
}
