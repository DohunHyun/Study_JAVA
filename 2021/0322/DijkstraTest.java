//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class DijkstraTest {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine().trim());
//        int V = Integer.parseInt(st.nextToken());
//        int start = 0;
//        int end = V-1;
//        final int INFINITY = Integer.MAX_VALUE;
//
//        int[][] matrix = new int[V][V];
//        int[] distance = new int[V];
//        boolean[] visited = new boolean[V];
//
//        for(int i=0; i<V; i++) {
//            st = new StringTokenizer(in.readLine().trim(), " ");
//            for(int j=0; j<V; j++) {
//                matrix[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[start] = 0;
//
//
//        for(int i=0; i<V; i++) {
//            int min = Integer.MAX_VALUE;
//            int current = 0;
//
//            // step1. 경유지가 된적 없는 애들 중 제일 가까운애 찾아서 경유지로 잡자
//            for(int j=0; j<V; j++) {
//                if(!visited[j] && distance[j] < min) {
//                    min = distance[j];
//                    current = j;
//                }
//            }
//            visited[current] = true;
//            if(current == end) {
//                break;
//            }
//
//            // step2. current 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
//            for(int c=0; c<V; c++) {
//                if(!visited[c] && matrix[current][c] != 0
//                        && distance[c] > min + matrix[current][c]) {
//                    distance[c] = min + matrix[current][c];
//                }
//            }
//
//
//        }
//
//    }
//}
