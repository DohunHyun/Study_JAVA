package SWEA1208;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] boxArray = new int[100];

        for(int cycle=0; cycle<10; cycle++) { // 10번 반복
            int count = sc.nextInt();

            for(int i=0; i<100; i++) { //배열 채우기
                boxArray[i] = sc.nextInt();
            }

            for(int i=0; i<count; i++) {
                boxArray[findMin(boxArray)]++;
                boxArray[findMax(boxArray)]--;
            }

            int gap = boxArray[findMax(boxArray)] - boxArray[findMin(boxArray)];
            System.out.println("#" + (cycle+1) + " " + gap);
        }
    }

    private static int findMax(int[] boxArray) {
        int MAX = 0;
        int MaxIndex = 0;
        for(int i=0; i<boxArray.length; i++) {
            if(boxArray[i] > MAX){
                MAX = boxArray[i];
                MaxIndex = i;
            }
        }
        return MaxIndex;
    }

    private static int findMin(int[] boxArray) {
        int MIN = 100;
        int MinIndex = 0;
        for(int i=0; i<boxArray.length; i++) {
            if(boxArray[i] < MIN){
                MIN = boxArray[i];
                MinIndex = i;
            }
        }
        return MinIndex;
    }
}
