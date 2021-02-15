package BKJN2961;

import java.util.Scanner;

public class Main {
    static int N;
    static long min = Integer.MAX_VALUE; // 차이 비교용
    static long bittertot, sourtot;
    static boolean[] isSelected;
    static Ingredient[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        list = new Ingredient[N];
        isSelected = new boolean[N];

        for(int cycle=0; cycle<N; cycle++) {
            list[cycle] = new Ingredient(sc.nextLong(), sc.nextLong());
        }

        subset(0);
        System.out.println(min);

    }

    public static class Ingredient {
        long bitter;
        long sour;

        Ingredient(long sour, long bitter) {
            this.bitter = bitter;
            this.sour = sour;
        }
    }

    public static void subset(int count) {
        if(count==N) { // 요리 재료 다 쓰면 끝!
            bittertot = 0; sourtot = 1;

            for(int i=0; i<N; i++){
                if(isSelected[i]) { // 선택한 재료면 계산해주고
                    bittertot = bittertot + list[i].bitter;
                    sourtot = sourtot * list[i].sour;
                }
            }

            long temp=0;
            if(bittertot > sourtot) temp = bittertot - sourtot;
            else temp = sourtot - bittertot;

            if(min > temp) min = temp;
            // 차이값과 min값 비교해서 더 작은걸 최솟값으로 저장.
            return;
        }

        // 재료 선택하는 경우
        isSelected[count] = true;
        subset(count+1);
        // 재료 선택 안하는 경우
        isSelected[count] = false;
        subset(count+1);
    }
}