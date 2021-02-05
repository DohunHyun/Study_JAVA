package SWEA1861;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle=1; cycle<=testcase; cycle++) {
            int N = sc.nextInt();
            int[][] room = new int[N][N];

            for(int i=0; i<N; i++) { // 방 채우기
                for(int j=0; j<N; j++) {
                    room[i][j] = sc.nextInt();
                }
            }

            int[][] count = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    count[i][j] = start(room, i, j);
                }
            }

            int MAX = 0; // 방에 들르는 횟수 최댓값
            int MaxIndex = room[0][0]; // 최댓값을 가지고있는 처음 시작숫자
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(count[i][j] > MAX) { // 새로운 횟수가 더 크면 바꿔주기
                        MAX = count[i][j];
                        MaxIndex = room[i][j];
                    } else if(count[i][j] == MAX) { // 같으면 시작숫자 비교
                        if(room[i][j] > MaxIndex) { // 새로운애가 더 크면 유지

                        } else { //새로운애가 더 숫자가 작으면 바꿔주기
                            MaxIndex = room[i][j];
                        }
                    }
                }
            }

            System.out.println("#" + cycle + " " + MaxIndex + " " + MAX);
        }

    }

    private static int start(int[][] room, int i, int j) {
        boolean[][] check = new boolean[room.length][room.length];// 갔던곳인지 체크
        check[i][j] = true; //시작점 체크
        int[] dx = {-1, 1, 0, 0}; //상하좌우
        int[] dy = {0, 0, -1, 1}; //
        int count=1; // 갈수있는 방의 수

        boolean loop = true;
        while(loop) {
            int failcount=0; //실패횟수 체크
            for(int direction=0; direction<4; direction++) { // 4방향 체크
                int x = i+dx[direction];
                int y = j+dy[direction];
                if(x>=0 && x<room.length && y>=0 && y<room.length // 모두 범위내
                    &&!check[x][y] && room[x][y] == (room[i][j] + 1)) {
                    // 하나큰거 발견하면 진행
                    i = x;
                    j = y;
                    check[x][y] = true;
                    count++;
                    break;
                } else { // 없으면
                    failcount+=1; //실패횟수 늘리고
                    if(failcount == 4) { // 4방향 다 실패하면
                        loop = false; //와일문 나가기
                    }
                }
            }
        }

        return count;
    }
}
