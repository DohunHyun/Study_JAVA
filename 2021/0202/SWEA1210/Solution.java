package SWEA1210;

import java.util.Scanner;

public class Solution {
    static int[][] ladder = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int cycle = 1; cycle<=10; cycle++) {
            int testcase = sc.nextInt();
            int[] endPoint = {99, 0};
            int[] startPoint;
            for(int i=0; i<100; i++) { // 사다리 배열 생성
                for(int j=0; j<100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<100; i++) { // 끝나는 곳 찾기
                if(ladder[99][i] == 2) endPoint[1] = i;
            }

            startPoint = goUp(endPoint);

            System.out.println("#" + testcase + " " + startPoint[1]);
        }
    }

    private static int[] goUp(int[] endPoint) {
        if(endPoint[0] == 0) { // 다 올라왔으면
            return endPoint;
        }

        if(checkLeft(endPoint)) { // 왼쪽에 길이 있으면
            endPoint = moveLeft(endPoint);
        } else if(checkRight(endPoint)) { // 오른쪽에 길이 있으면
            endPoint = moveRight(endPoint);
        } else { // 다없으면 위로

        }

        endPoint[0] = endPoint[0] - 1; // 한 칸 위로
        goUp(endPoint);

        return endPoint;
    }

    private static int[] moveRight(int[] endPoint) {
        while (endPoint[1] < 99 && ladder[endPoint[0]][endPoint[1]+1] == 1) {
            endPoint[1] += 1;
        }
        return endPoint;
    }

    private static boolean checkRight(int[] endPoint) {
        if (endPoint[1] < 99 && ladder[endPoint[0]][endPoint[1]+1] == 1) {
            return true;
        }
        return false;
    }

    private static int[] moveLeft(int[] endPoint) {
        while (endPoint[1] > 0 && ladder[endPoint[0]][endPoint[1]-1] == 1) {
            endPoint[1] -= 1;
        }
        return endPoint;
    }

    private static boolean checkLeft(int[] endPoint) {
        if (endPoint[1] > 0 && ladder[endPoint[0]][endPoint[1]-1] == 1) {
            return true;
        }
        return false;
    }
}
