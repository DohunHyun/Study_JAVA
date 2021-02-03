package SWEA1873;

import java.util.Scanner;

public class Solution {
    static int[] locationDirection;
    static String[][] land;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int cycle=0; cycle<testcase; cycle++) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            sc.nextLine();
            int direaction = 0; //1,2,3,4 상하좌우
            land = new String[height][width];

            for(int i=0; i<height; i++) { // map 만들기
                String input = sc.nextLine();
                String[] array = input.split("");
                for(int j=0; j<width; j++) {
                    land[i][j] = array[j];
                }
            }

            int count = sc.nextInt();
            sc.nextLine();
            String inputCommand = sc.nextLine();
            String[] Command = inputCommand.split("");
            int commandIndex = 0;
            locationDirection = findLocation(); // 시작 위치, 방향 찾기
            String commandTemp = Command[commandIndex];

            while(!commandTemp.equals("Q")) {
                switch (commandTemp) {
                    case "S":
                        shoot();
                        break;
                    case "U":
                        locationDirection[2] = 1;
                        move();
                        break;
                    case "D":
                        locationDirection[2] = 2;
                        move();
                        break;
                    case "L":
                        locationDirection[2] = 3;
                        move();
                        break;
                    case "R":
                        locationDirection[2] = 4;
                        move();
                        break;
                }

                if(commandIndex<count-1) { //다음 입력
                    commandIndex++;
                    commandTemp = Command[commandIndex];
                } else { // 종료
                    commandTemp = "Q";
                    if(locationDirection[2] == 1) {
                        land[locationDirection[0]][locationDirection[1]] = "^";
                    } else if(locationDirection[2] == 2){
                        land[locationDirection[0]][locationDirection[1]] = "v";
                    } else if(locationDirection[2] == 3){
                        land[locationDirection[0]][locationDirection[1]] = "<";
                    } else if(locationDirection[2] == 4){
                        land[locationDirection[0]][locationDirection[1]] = ">";
                    }
                }
            }

            System.out.print("#" + (cycle+1) + " ");
            for(int i=0; i<land.length; i++) {
                for(int j=0; j<land[0].length; j++) {
                    System.out.print(land[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static String[][] move() {
        int x = locationDirection[0];
        int y = locationDirection[1];
        int direction = locationDirection[2]-1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if(x+dx[direction]<0 || x+dx[direction] >= land.length || y+dy[direction] < 0 || y+dy[direction] >= land[0].length) {
            return land;
        }
        if(land[x+dx[direction]][y + dy[direction]].equals(".")) { // 안막혔으니까 이동
            land[x][y] = ".";
            locationDirection[0] = x+dx[direction];
            locationDirection[1] = y+dy[direction];
        } else { // 막혔으니까 방향만 전환
//            locationDirection[2] = direction;
        }

        return land;
    }

    private static String[][] shoot() {

        int x = locationDirection[0];
        int y = locationDirection[1];
        int direction = locationDirection[2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        switch (direction) {
            case 1: // 위로 쏘기
                for(int i = x-1; i>=0; i--) {
                    if(land[i][y].equals(".") || land[i][y].equals("-")) {
                        continue; // 지나가기
                    } else if(land[i][y].equals("#")) { // 막힘
                        break;
                    } else if(land[i][y].equals("*")) { // 그냥벽이면 부수고 그만.
                        land[i][y] = ".";
                        break;
                    }
                }
                break;
            case 2: // 아래로 쏘기
                for(int i = x+1; i<land.length; i++) {
                    if(land[i][y].equals(".") || land[i][y].equals("-")) {
                        continue; // 지나가기
                    } else if(land[i][y].equals("#")) { // 막힘
                        break;
                    } else if(land[i][y].equals("*")) { // 그냥벽이면 부수고 그만.
                        land[i][y] = ".";
                        break;
                    }
                }
                break;
            case 3: // 왼쪽으로
                for(int i = y-1; i>=0; i--) {
                    if(land[x][i].equals(".") || land[x][i].equals("-")) {
                        continue; // 지나가기
                    } else if(land[x][i].equals("#")) { // 막힘
                        break;
                    } else if(land[x][i].equals("*")) { // 그냥벽이면 부수고 그만.
                        land[x][i] = ".";
                        break;
                    }
                }
                break;
            case 4: // 오른쪽으로
                for(int i = y+1; i<land[0].length; i++) {
                    if(land[x][i].equals(".") || land[x][i].equals("-")) {
                        continue; // 지나가기
                    } else if(land[x][i].equals("#")) { // 막힘
                        break;
                    } else if(land[x][i].equals("*")) { // 그냥벽이면 부수고 그만.
                        land[x][i] = ".";
                        break;
                    }
                }
                break;
        }
        return land;
    }

    private static int[] findLocation() {
        int[] location;

        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j].equals("<")) { // direction : 상하좌우
                    location = new int[]{i, j, 3};
                    return location;
                } else if(land[i][j].equals(">")) {
                    location = new int[]{i, j, 4};
                    return location;
                } else if(land[i][j].equals("^")) {
                    location = new int[]{i, j, 1};
                    return location;
                } else if(land[i][j].equals("v")) {
                    location = new int[]{i, j, 2};
                    return location;
                }
            }
        }
        return null;
    }
}
