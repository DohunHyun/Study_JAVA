package SWEA3499;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for(int cycle = 1; cycle<=testcase; cycle++) {
            StringBuilder sb = new StringBuilder();
            int cardNum = Integer.parseInt(br.readLine());
            int halfnum; // 반으로 나눌 수

            if(cardNum%2 == 0) { //짝수개일때
                halfnum = cardNum/2;
            } else { // 카드가 홀수개일때
                halfnum = (cardNum+1)/2;
            }

            String input = br.readLine();
            String[] inputArray = input.split(" ");
            for (int half = 0; half < halfnum; half++) { // 전체개수 반만큼
                for (int i = 0; i < cardNum; i++) { // 카드들 체크
                    if(i % halfnum == half) {
                        sb.append(inputArray[i] + " ");
                    }
                }
            }
            bw.write("#" + cycle + " " + sb + "\n");
//            System.out.println("#" + cycle + " " + sb);
            bw.flush();
//            sb.delete(0, sb.length());
        }

//        bw.close();
//        br.close();

    }
}
