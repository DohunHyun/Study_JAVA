package SWEA5643;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_키순서 {
    static int N, M;
    static int[][] adj;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for(int t=1; t<=TC; t++) {
            N = sc.nextInt(); // 학생 수
            M = sc.nextInt(); // 비교 횟수

            adj = new int[N+1][N+1];

            for(int i=0; i<M; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                adj[A][B] = 1;
            }

            answer = 0; // 자기 순서 아는 사람 수

            for(int i=1; i<=N; i++) {
                int tall = tallCount(i);
                int small = smallCount(i);

                if(tall + small == N-1) answer++;
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    private static int smallCount(int index) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(index);
        visited[index] = true;

        int small = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i=1; i<=N; i++) {
                if(adj[i][tmp] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    small++;
                }
            }
        }

        return small;
    }

    private static int tallCount(int index) { // i보다 큰사람을 세보자
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(index);
        visited[index] = true;

        int tall = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i=1; i<=N; i++) {
                if(adj[tmp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    tall++;
                }
            }
        }

        return tall;
    }
}
