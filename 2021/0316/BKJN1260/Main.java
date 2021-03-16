package BKJN1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] map;
    static boolean[] visitedD;
    static boolean[] visitedB;
    static String D;
    static String B;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        map = new int[N+1][N+1];
        visitedD = new boolean[N+1];
        visitedB = new boolean[N+1];
        D = "";
        B = "";

        for(int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[from][to] = 1;
            map[to][from] = 1;
        }

        dfs(V);

        queue = new LinkedList();
        bfs(V);

        System.out.println(D);
        System.out.println(B);


    }

    private static void bfs(int start) {
        visitedB[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            B += Integer.toString(temp) + " ";

            for(int i=1; i<=N; i++) {
                if(!visitedB[i] && map[temp][i] == 1) {
                    queue.add(i);
                    visitedB[i] = true;
                }
            }
        }

    }

    private static void dfs(int start) {
        visitedD[start] = true;
        D += Integer.toString(start) + " ";

        for(int i=1; i<=N; i++) {
            if(!visitedD[i] && map[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
