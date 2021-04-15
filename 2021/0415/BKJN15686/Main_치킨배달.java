package BKJN15686;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_치킨배달 {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> list;
    static int store;
    static boolean[] checkStore;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 도시 크기
        M = sc.nextInt(); // 최대 치킨집 수

        map = new int[N][N];
        list = new ArrayList();

        store = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    list.add(new int[] {i,j});
                    store++;
                }
            }
        }
        checkStore = new boolean[list.size()];

        // 치킨집 중 몇개 고르기
        comb(0, 0);

        // 치킨거리 계산하기
    }

    private static void comb(int cnt, int index) {

        // 전체 store 갯수에서 m 개만큼 고르기
        if(cnt == M) { // 다 골랐으면 계산 해보자
//            calc();
        }


        checkStore[index] = true;
        comb(cnt+1, index+1);
        checkStore[index] = false;
        comb(cnt, index+1);

    }
}
