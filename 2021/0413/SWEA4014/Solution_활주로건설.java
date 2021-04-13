package SWEA4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_활주로건설 {
    static int N, X;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int cycle=1; cycle<=TC; cycle++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                br.readLine();
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++) { //
                make(i, 0); // 가로방향
                make(i, 1); // 세로방향
            }

            System.out.println("#" + cycle + " " + answer);

        }
    }

    private static void make(int start, int direction) {
        int temp;
        if(direction == 0) { // 가로 방향 진행
            temp = map[start][0];
        } else { // 세로 방향
            temp = map[0][start];
        }

        for(int i=1; i<N; i++) {
            if(direction == 0) { // 가로 방향 진행
//                temp = map[start][i];
                if(temp == map[start][i]) { // 다음칸도 높이가 같으면 그냥 진행.
                    continue;
                } else if (Math.abs(temp - map[start][i]) > 1) { // 차이가 2 이상 나면
                    return;
                } else if(temp < map[start][i]) { // 다음칸이 더 높을때
                    // i 이전 x만큼 다 높이가 temp 이어야함.
                    for(int j=i-1; j>i-1-X; j--) {
                        if(j < 0) return; // 지형 벗어나면 실패
                        if(map[start][j] != temp) return; // 경사로 위치내에 위치가 달라지면 실패
                    }
                    temp = map[start][i];
                } else if(temp > map[start][i]) { // 다음칸이 더 낮을때
                    for(int j=i; j<i+X; j++) {
                        if(j >= N) return; // 지형 벗어나면 실패
                        if(map[start][j] != map[start][i]) return; // 경사로 위치내에 위치가 달라지면 실패
                    }
                    temp = map[start][i];
                }
                answer++;
            } else { // 세로 방향
//                temp = map[i][start];
                if(temp == map[i][start]) { // 다음칸도 높이가 같으면 그냥 진행.
                    continue;
                } else if (Math.abs(temp - map[i][start]) > 1) { // 차이가 2 이상 나면
                    return;
                } else if(temp < map[i][start]) { // 다음칸이 더 높을때
                    // i 이전 x만큼 다 높이가 temp 이어야함.
                    for(int j=i-1; j>i-1-X; j--) {
                        if(j < 0) return; // 지형 벗어나면 실패
                        if(map[j][start] != temp) return; // 경사로 위치내에 위치가 달라지면 실패
//                        map[j][start] = temp;
                    }
                    temp = map[i][start];
                } else if(temp > map[i][start]) { // 다음칸이 더 낮을때
                    for(int j=i; j<i+X; j++) {
                        if(j >= N) return; // 지형 벗어나면 실패
                        if(map[j][start] != map[i][start]) return; // 경사로 위치내에 위치가 달라지면 실패
//                        map[j][start] = temp;
                    }
                    temp = map[i][start];
                }

                answer++;
            }


        }

    }
}
