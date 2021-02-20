package BKJN15686;

import java.util.ArrayList;
import java.util.Scanner;

public class Main { // 백준 치킨배달
    static int[][] map;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;
    static int N, M;
    static boolean[] select;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if(map[i][j] == 2) {
                    chicken.add(new Point(i,j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        select = new boolean[chicken.size()];
        comb(0, 0);
        System.out.println(answer);


    }

    private static void comb(int index, int count) {
        if(count == M) {
            int sum = 0;

            for(Point h : home) {
                int dist = Integer.MAX_VALUE; // 지금 가정집에서

                for(int i=0; i<chicken.size(); i++) { // 모든 치킨집중
                    if(select[i]) { // 살아남는 치킨집이 있으면 거리 계산
                        Point alive = chicken.get(i);
                        dist = Math.min(dist, Math.abs(h.i - alive.i) + Math.abs(h.j - alive.j));
                        // 제일 적은 거리로 dist 찾기
                    }
                }

                sum += dist; // 모든 집에 대해서 가장 가까운 치킨집 거리 더해주기
            }

            answer = Math.min(answer, sum);
            return;
        } else if(index == chicken.size()) {
            return;
        }

        select[index] = true;
        comb(index+1, count+1);
        select[index] = false;
        comb(index+1, count);
    }


    static class Point{
        int i,j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
