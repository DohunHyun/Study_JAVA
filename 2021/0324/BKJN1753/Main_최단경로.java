package BKJN1753;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_최단경로 {
        static int N, K;
        static int start;
        static LinkedList<Node>[] adList;
        static StringBuilder sb;
        static boolean[] visited;
        static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        start = sc.nextInt();

        adList = new LinkedList[N+1];

        for(int i=1; i<=N; i++) {
            adList[i] = new LinkedList<>();
        }

        sb = new StringBuilder();
        visited = new boolean[N+1];
        distance = new int[N+1];

        for(int i=0; i<K; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            adList[from].add(new Node(to, weight));
        }

        /// 다익스트라 시작!
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 경유지
            if(visited[now.vertex]) continue; // 이미 경유한적 있음. 다음!

            visited[now.vertex] = true;
            for(Node next : adList[now.vertex]) { // 현재 경유지에서 출발하는 간선들
                if(distance[next.vertex] > distance[now.vertex] + next.weight) {
                    distance[next.vertex] = distance[now.vertex] + next.weight;
                    pq.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        } // end dijkstra

        for(int i=1; i<=N; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

//    static boolean isAllVisit() {
//        for(int i=0; i<=N; i++) {
//            if(!visited[i]) return false;
//        }
//        return true;
//    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
