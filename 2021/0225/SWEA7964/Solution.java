package SWEA7964;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int cycle=1; cycle<=testcase; cycle++) {
            int cities = sc.nextInt();
            int distance = sc.nextInt();

            int[] map = new int[cities];
            for(int i=0; i<cities; i++) {
                map[i] = sc.nextInt();
            }

            int cnt = 0;
            int i=0;

            while(true) {
                if(cities<=i) break;
                if(map[i] == 0) { // 관문이 없으면
                    map[i] = 1; // 설치하고
                    cnt++;

                } else { // 관문이 있으면
                    int temp=0;
                    for(int j=1; j<=distance; j++) {
                        if(i+j < cities && map[i+j] == 1) temp = j;
                    }

                    if(temp == 0) temp = distance;
                    i += temp;
                }
            }

            System.out.println("#" + cycle + " " + cnt);
        }
    }
}
