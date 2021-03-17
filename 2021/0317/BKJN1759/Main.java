package BKJN1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main { // 백준 1759 암호만들기
    static int L, C;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new String[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            input[i] = st.nextToken();
        }

        Arrays.sort(input);
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        comb(0, 0, 0, 0, "");

    }

    private static void comb(int start, int count, int jCnt, int mCnt, String word) {
        if(count == L) { // 다 채웠다! 자음, 모음 개수 파악
            if(jCnt >= 2 && mCnt >= 1) {
                System.out.println(word);
                return;
            }
        }

        if(start == C) { // 다 못채웠는데 끝까지 왔다.... 실패
            return;
        }

        // 선택 하는 경우
        if(input[start].equals("a") || input[start].equals("e") ||
                input[start].equals("i") || input[start].equals("o") || input[start].equals("u")) {
            // 모음일때
            comb(start+1, count+1, jCnt, mCnt+1, word+input[start]);
        } else {
            comb(start+1, count+1, jCnt+1, mCnt, word+input[start]);
        }

        // 선택 안하는 경우
        comb(start+1, count, jCnt, mCnt, word);



    }
}
