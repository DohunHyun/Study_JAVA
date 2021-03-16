package SWEA1238;

import java.util.Scanner;

public class Solution {

    static boolean[] visited; // 방문 여부
    static int[][] list; // 인접행렬
    static int[] depth; // 깊이 측정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[101]; // 1~100 까지 숫자들 인덱스로 관리

        for(int cycle=1; cycle<=10; cycle++) {

            int length = sc.nextInt();
            int start = sc.nextInt();
            list = new int[101][101]; // 인접행렬
            depth = new int[101]; // 깊이 저장

            for(int i=0; i<length; i+=2) { // 그래프 만들기, 인접리스트
                int from = sc.nextInt();
                int to = sc.nextInt();

                list[from][to] = 1;
            }

            // start 부터 탐색 시작
            dfs(start, 1);

            int answer = 0;
            int maxDepth = 0;
            for(int i=1; i<list.length; i++) {
                if(depth[i] >= maxDepth) {
                    answer = i;
                    maxDepth = depth[i];
                }
            }
            System.out.println("#" + cycle + " " + answer);
        }
    }

    private static void dfs(int index, int distance) {

        if(depth[index] != 0) { // 이미 한번 왔었다! 그럼 리턴
            return;
        }

        depth[index] = distance; // 방문한 곳 깊이 측정

        for(int i=1; i<101; i++) { // 자기 자신과 연결된 곳 찾기
            if(list[index][i] != 0) { // 연결 됐다 가보자!
                dfs(i, distance+1);
           }
        }
    }
}
