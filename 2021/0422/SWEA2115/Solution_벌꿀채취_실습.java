package SWEA2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_벌꿀채취_실습 {

    static int N, M, C;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1; t<=TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + t + " " + getMaxBenefit());
        }

    }

    private static int getMaxBenefit() {
        return processCombination();
    }

    private static int processCombination() {
        int result = 0;
        int aBenefit = 0;
        int bBenefit = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=N-M; j++) { // 첫 열부터 연속된 M개 채취 가능한 열까지.
                // 일꾼 A의 선택

                // 선택된 M개 벌통에서 얻을 수 있는 최대 이익
                maxSum = 0;
                makeMaxSubset(i, j, 0, 0, 0);
                aBenefit = maxSum;

                maxSum = 0;
                bBenefit = 0;
                // 일꾼 B의 선택
                // 일꾼 A와 같은 행에 뒤쪽 열에서 선택
                for(int j2 = j+M; j2<=N-M; j2++) {
                    makeMaxSubset(i, j2, 0, 0, 0);
                    if(maxSum > bBenefit) bBenefit = maxSum;
                }

                // 일꾼 A의 다음 행 부터 선택
                for(int i2 = i+1; i2<N; i2++) {
                    for(int j2=0; j2<=N-M; j2++) {
                        makeMaxSubset(i2, j2, 0, 0, 0);
                        if(maxSum > bBenefit) bBenefit = maxSum;
                    }
                }
                bBenefit = maxSum;
                if(result < aBenefit+bBenefit) result = aBenefit+bBenefit;
            }
        }

        return result;
    }

    private static int maxSum = 0;
    private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {

        if(sum > C) return;

        // 마지막 원소까지 다 부분집합에 고려했다면 끝.
        if(cnt == M) {
            if(maxSum < powerSum) maxSum = powerSum;
            return;
        }

        // 선택
        makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powerSum+(map[i][j]*map[i][j]));

        // 비선택
        makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
    }




}
