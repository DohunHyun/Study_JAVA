package BKJN9205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int cycle=1; cycle<=T; cycle++) {
            int n = sc.nextInt(); // 편의점 개수
            map = new int[n+2][2];
            boolean[] visited = new boolean[n+2];

            for(int i=0; i<n+2; i++) { // 좌표값 입력
                for(int j=0; j<2; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            Queue<Integer> queue = new LinkedList();
            queue.add(0);
            visited[0] = true;
            boolean flag = false;

            while (!flag && !queue.isEmpty()) {
                int temp = queue.poll();
//                if(temp == n+1) {
//                    flag = true;
//                    break;
//                }
                for(int i=0; i<n+2; i++) {
                    if(!visited[i] && workPossible(temp, i)) {
                        queue.add(i);
                        visited[i] = true;
                        if(i == n+1) {
                            flag = true;
                        }
                    }
                }
            }

            if(flag) System.out.println("happy");
            else System.out.println("sad");

        }
    }

    private static boolean workPossible(int temp, int i) {
        int distance = Math.abs(map[temp][0]-map[i][0]) + Math.abs(map[temp][1]-map[i][1]);

        if(distance > 1000) return false;
        return true;
    }
}
