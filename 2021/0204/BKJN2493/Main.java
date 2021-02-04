package BKJN2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Top> stack = new Stack();
        int towerNum = Integer.parseInt(br.readLine());
        int height;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=towerNum; i++) {
            height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()) {
                if(stack.peek().height >= height) {
                    // 새로 넣는 타워가 더 작거나 같으면
                    // 이미 있는게 더 클 때, 그럼 푸쉬할 필요 없음.

                    sb.append(stack.peek().index + " ");
                    //출력에 지금 스택에 top에 있는 정보 넣어주고
                    break;
                    //반복 그만. pop 안하고 그만.
                }
                stack.pop();
            }

            if(stack.isEmpty()) { // 스택에 아무것도 없으면
                //출력에 0 넣기
                sb.append(0 + " ");
            }

            //스택에 지금 탑 높이 넣기
            stack.push(new Top(height, i));
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();

    }

    private static class Top {
        private int height;
        private int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
