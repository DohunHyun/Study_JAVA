package SWEA5356;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int cycle=1; cycle<=testcase; cycle++) {
            StringBuilder sb = new StringBuilder();
            char[][] map = new char[5][];
            int max=0;
            for(int i=0; i<5; i++) {
                map[i] = br.readLine().toCharArray();
                if(max < map[i].length) max = map[i].length;
            }

            for(int i=0; i<max; i++) {
                for(int j=0; j<5; j++) {
                    if(i > map[j].length-1) continue;
                    sb.append(map[j][i]);
                }
            }

            System.out.println("#"+cycle + " " + sb.toString());

        }

    }
}
