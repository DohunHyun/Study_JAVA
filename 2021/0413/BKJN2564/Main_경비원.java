package BKJN2564;

import java.util.Scanner;

public class Main_경비원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 가로
        int y = sc.nextInt(); // 세로

        int N = sc.nextInt(); // 가게 수
        int[][] map = new int[N+1][2];
        int answer = 0;

        // 1:북, 2:남, 3:서, 4:동
        for(int i=0; i<N+1; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            if(map[i][0] == map[N][0]) { // 상점이랑 방향이 같을 경우.
                answer += Math.abs(map[i][1] - map[N][1]);
            } else if(map[i][0] + map[N][0] == 3) { // 북남
                answer += y; // 세로 더해주고
                if(map[i][1] + map[N][1] > 2*x-(map[i][1] + map[N][1])) {
                    answer += 2*x-(map[i][1] + map[N][1]);
                } else {
                    answer += map[i][1] + map[N][1];
                }
            } else if(map[i][0] + map[N][0] == 7) { // 동서
                answer += x; // 가로 더해주고
                if(map[i][1] + map[N][1] > 2*y-(map[i][1] + map[N][1])) {
                    answer += 2*y-(map[i][1] + map[N][1]);
                } else {
                    answer += map[i][1] + map[N][1];
                }
            } else if(map[i][0] + map[N][0] == 4) { // 북서
                if(map[i][0] == 1) { // i가 북일때
                    answer += map[i][1] + map[N][1];
                } else { // N이 북일때
                    answer += map[i][1] + map[N][1];
                }
            } else if(map[i][0] + map[N][0] == 5 && (map[i][0] == 1 || map[N][0] == 1)) { // 북동
                if(map[i][0] == 1) { // i가 북일때
                    answer += x-map[i][1] + map[N][1];
                } else { // N이 북일때
                    answer += x-map[N][1] + map[i][1];
                }
            } else if(map[i][0] + map[N][0] == 5 && (map[i][0] == 2 || map[N][0] == 2)) { // 남서
                if(map[i][0] == 1) { // i가 남일때
                    answer += map[i][1] + y-map[N][1];
                } else { // N이 남일때
                    answer += map[N][1] + y-map[i][1];
                }
            } else if(map[i][0] + map[N][0] == 6) { // 남동
                if(map[i][0] == 1) { // i가 일때
                    answer += x-map[i][1] + y-map[N][1];
                } else { // N이 남일때
                    answer += x-map[N][1] + y-map[i][1];
                }
            }
        }
        System.out.println(answer);
    }
}
