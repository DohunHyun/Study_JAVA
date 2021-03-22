package BKJN1753;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int V,E,K;
    static int[][] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점개수
        E = sc.nextInt(); // 간선개수
        K = sc.nextInt(); // start
        list = new int[V+1][V+1];

        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        for(int i=0; i<E; i++) {
            int x = sc.nextInt(); // from
            int y = sc.nextInt(); // to
            int w = sc.nextInt(); // weight

            list[x][y] = w;
        }

        for(int i=1; i<=V; i++) {
            int min = Integer.MAX_VALUE;
            int current = K;

            // current 정하기
            for(int j=1; j<=V; j++) {
                if(!visited[j] && distance[j] < min) {
                        // 방문한적 없고 지금있는 곳에서 갈 수 있는 가장 가까운곳 찾기
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true;

            // 경유지로부터 갈수있는 곳들 찾기. 이미 간곳이어도 돌아가면 더 좋을수도 있는거 찾기
            for(int j=1; j<=V; j++) {
                if(!visited[j] && list[current][j] != 0
                        && distance[j] > min + list[current][j] ) {
                    distance[j] = min + list[current][j];
                }
            }
        }

        System.out.println(Integer.MAX_VALUE);
        for(int i=1; i<=V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }




    }


}
