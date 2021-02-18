package SWEA1247;

import java.util.Scanner;

public class Solution {
    static int N;
    static int[] start, end;
    static int[][] customer;
    static int minRoute;
    static boolean[] visited;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle=1; cycle<=testcase; cycle++) {
            N = sc.nextInt(); // 고객 수

            customer = new int[N+2][2]; // 출발지와 도착지까지
            visited = new boolean[N+2];

            customer[0][0] = sc.nextInt(); // 출발지 정보
            customer[0][1] = sc.nextInt();

            customer[N+1][0] = sc.nextInt(); // 도착지 정보
            customer[N+1][1] = sc.nextInt();

            for(int i=1; i<=N; i++) {
                customer[i][0] = sc.nextInt();
                customer[i][1] = sc.nextInt();
            }

            minRoute = Integer.MAX_VALUE;
            visited[0] = true;
            findRoute(0,0, 0);
            System.out.println("#" + cycle + " " + minRoute);



        }
    }

    private static void findRoute(int index, int depth, int route) {
//        if(route == 0) { // 이제 시작일 경우
//            route += calcDistance(0, index); // 출발지부터의 거리
//        }

        if(route >= minRoute) return; // 이미 최솟값보다 크면 그냥 끝내기

        if(depth == N) { // 전부다 들렸을때
            route += calcDistance(index, N+1); // 도착지까지의 거리 더해주기
            if(route < minRoute) minRoute = route;
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                findRoute(i, depth+1, route + calcDistance(index, i));
                visited[i] = false;
            }
        }
    }

    private static int calcDistance(int i, int index) {
        return Math.abs(customer[i][0] - customer[index][0]) + Math.abs(customer[i][1] - customer[index][1]);
    }
}
