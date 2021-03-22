package BKJN1753;

import java.util.*;

public class Main {
    static int V,E,K;
    static List<List<Node>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점개수
        E = sc.nextInt(); // 간선개수
        K = sc.nextInt(); // start
        list = new ArrayList<List<Node>>();

        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        for(int i=0; i<=V; i++) {
            list.add(new ArrayList<Node>());
        }


        for(int i=0; i<E; i++) {
            int x = sc.nextInt(); // from
            int y = sc.nextInt(); // to
            int w = sc.nextInt(); // weight
            list.get(x).add(new Node(y, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(K, distance[K]));

        Node current = null;

        for(int i=0; i<V; i++) {

            while(!queue.isEmpty()) {

                current = queue.poll();
                if(visited[current.vertex]) continue;

                visited[current.vertex] = true;
                if(current.vertex == i)  {

                    break;
                }

                for(Node node : list.get(current.vertex)) {
                    if(!visited[node.vertex]  &&
                    distance[node.vertex] > current.totalDistance + node.totalDistance) {
                        distance[node.vertex] = current.totalDistance + node.totalDistance;
                        queue.offer(new Node(node.vertex, distance[node.vertex]));
                    }
                }



            }
        }





//        for(int i=1; i<=V; i++) {
//            int min = Integer.MAX_VALUE;
//            int current = K;
//
//            // current 정하기
//            for(int j=1; j<=V; j++) {
//                if(!visited[j] && distance[j] < min) {
//                        // 방문한적 없고 지금있는 곳에서 갈 수 있는 가장 가까운곳 찾기
//                    min = distance[j];
//                    current = j;
//                }
//            }
//
//            visited[current] = true;
//
//            // 경유지로부터 갈수있는 곳들 찾기. 이미 간곳이어도 돌아가면 더 좋을수도 있는거 찾기
//            for(int j=1; j<=V; j++) {
//                if(!visited[j] && list[current][j] != 0
//                        && distance[j] > min + list[current][j] ) {
//                    distance[j] = min + list[current][j];
//                }
//            }
//        }

        for(int i=1; i<=V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }




    }


    private static class Node implements Comparable<Node>{
        int vertex;
        int totalDistance;
        Node(int vertex, int totalDistance) {
            this.vertex = vertex;
            this.totalDistance = totalDistance;
        }


        @Override
        public int compareTo(Node o) {
            return this.totalDistance - o.totalDistance;
        }
    }
}
