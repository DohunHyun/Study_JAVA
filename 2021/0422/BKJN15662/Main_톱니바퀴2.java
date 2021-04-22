package BKJN15662;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_톱니바퀴2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            String[][] map = new String[N][N];

            for(int i=0; i<N; i++) {
                map[i] = br.readLine().split("");
            }



            System.out.println("#" + t + " ");
        }

    }
}
