package BKJN2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int towerNum = Integer.parseInt(br.readLine());
        int[] towerArray = new int[towerNum];
        int[] receiveArray = new int[towerNum];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<towerNum; i++) {
            towerArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = towerNum-1; i>=0; i--) { // i 는 전파 쏘는 타워
            for(int j = i-1; j>=0; j--) { // j 는 전파 받는 타워
                if(towerArray[i] < towerArray[j]) { // 전파 받는 타워가 더 크면 수신
                    receiveArray[i] = j+1;
                    break;
                }
            }
        }

        for(int i=0; i<receiveArray.length; i++) {
            System.out.print(receiveArray[i] + " ");
        }

    }

}
