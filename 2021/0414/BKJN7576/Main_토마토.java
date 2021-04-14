package BKJN7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_토마토 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 상자 가로
        int N = sc.nextInt(); // 상자 세로
        int[][] box = new int[N][M];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int count = 0;
        Queue<Tomato> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1) { // 익은 애들 큐에 넣고 시작하기
                    queue.add(new Tomato(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for(int i=0; i<4; i++) {
                int xx = tomato.x + dx[i];
                int yy = tomato.y + dy[i];
                if(xx>=0 && xx<N && yy>=0 && yy<M && box[xx][yy] == 0) {
                    box[xx][yy] = box[tomato.x][tomato.y] + 1;
                    queue.add(new Tomato(xx, yy));
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) { // 안익은게 있으면 -1
                    count = -1;
                    max = 0;
                    break;
                }
                if(box[i][j] > max) max = box[i][j];
            }
            if(count == -1) break;
        }

        System.out.println(max-1);

    }

    private static class Tomato {
        int x;
        int y;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
