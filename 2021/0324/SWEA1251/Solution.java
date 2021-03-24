package SWEA1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Solution {
    static int N;
    static Node[] island;
//    static boolean[] visited;
    static Double E;
    static Double ans;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int cycle=1; cycle<=T; cycle++) {
            N = Integer.parseInt(br.readLine()); // 섬 개수
            island = new Node[N]; // 섬 배열

//            visited = new boolean[N]; // 방문했는지 체크 배열
            ans = 0.0;

            // 섬 x 좌표 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                island[i] = new Node(Integer.parseInt(st.nextToken()), 0, 0);
            }

            // 섬 y 좌표 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                island[i].y = Integer.parseInt(st.nextToken());
            }

            ans = 0.0;
            E = Double.parseDouble(br.readLine());

             // 모든 점에서 각각의 점까지 거리 구하기
            ArrayList<Node> weights = new ArrayList<>();
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    weights.add(new Node(i, j, calcDistance(i, j)));
                }
            }

            Collections.sort(weights, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.weight < o2.weight)
                        return -1;
                    else if(o1.weight > o2.weight)
                        return 1;
                    return 0;
                }
            });

            // make-set
            parent = new int[N];
            for(int i=0; i<N; i++) {
                parent[i] = i;
            }

            for(int i=0; i<weights.size(); i++) {
                if(find(weights.get(i).x) != find(weights.get(i).y)) {
                    // x랑 y의 부모가 다르면 -> union
                    union(weights.get(i).x, weights.get(i).y);
                    ans += weights.get(i).weight;
                }
            }

            System.out.printf("#%d %.0f\n", cycle, ans);






        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static Double calcDistance(int index, int i) {
        int xA = island[index].x;
        int yA = island[index].y;
        int xB = island[i].x;
        int yB = island[i].y;

        return E * (Math.pow(xA-xB,2) + Math.pow(yA-yB, 2));
    }

    static class Node {
        int x;
        int y;
        double weight;

        Node(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

//    private static void dfs(int index, int count, double cost) {
//        if(cost >= ans) return;
//        if(index >= N) return;
//
//        if(count == N-1) { // 다 돌았다!
//            ans = Math.min(cost, ans);
//            return;
//        }
//
////        // 자기랑 visited[true]중에 제일 가까운 애랑 연결
////        Double distance = Double.MAX_VALUE;
////        for(int i=0; i<N; i++) {
////            if(visited[i]) { // 갈 곳이 이미 연결되야함.
////                distance = Math.min(calcDistance(index, i), distance);
////            }
////        }
////
////        visited[index] = true;
////        dfs(index+1, count+1, cost+distance);
//
//        //완전탐색으로 해보자. 다 연결해!!
//        visited[index] = true;
//        for(int i=0; i<N; i++) {
//            if(i==index) { // 자기자신이랑은 연결 안함
//
//            } else { // 남이랑 연결!
//                if(visited[i]) { // 이미 방문 했던곳이면 카운트 안하고
//                    dfs(index+1, count, cost);
//                } else { // 방문 안한곳이면 연결해주고!
//                    dfs(index+1, count+1, cost+Math.pow(calcDistance(index,i),2));
//                }
//
//            }
//        }
//    }

}
