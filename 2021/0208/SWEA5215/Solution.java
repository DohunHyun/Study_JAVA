package SWEA5215;

import java.util.Scanner;

public class Solution {
    static int N, L, maxScore = 0;
    static Food[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int cycle=1; cycle<=testCase; cycle++) {
            maxScore = 0;
            N = sc.nextInt(); // 재료 개수
            L = sc.nextInt(); // 제한 칼로리

            list = new Food[N];

            for(int ingredients=0; ingredients<N; ingredients++) {
                list[ingredients] = new Food(sc.nextInt(), sc.nextInt());
            }

            hamburger(0, 0, 0);
            System.out.println("#" + cycle + " " + maxScore);
        }
    }

    private static void hamburger(int index, int score, int calorie) {

        if(calorie > L) return;

        if(index == N) {
            if(maxScore < score) {
                maxScore = score;
            }
            return;
        }

        hamburger(index+1, score + list[index].score, calorie + list[index].calorie);
        hamburger(index+1, score, calorie);

    }

    private static class Food {
        int score;
        int calorie;

        Food(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
        }
    }
}
