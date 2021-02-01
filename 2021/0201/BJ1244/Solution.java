package BJ1244;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] array = new int[size+1];
        for(int i=1; i<=size; i++) {
            array[i] = sc.nextInt();
        }

        int studentNum = sc.nextInt();

        for(int i=0; i<studentNum; i++) {
            int sex = sc.nextInt();
            int number = sc.nextInt();

            if(sex == 1) { // 남학생
                for(int j = number; j<=size; j+=number) {
                    if( j % number == 0) { // 배수일때
                        if(array[j] == 0) array[j] = 1;
                        else array[j] = 0;
                    }
                }
            }
            else { // 여학생
                if(array[number] == 0) array[number] = 1;
                else array[number] = 0;

                for(int k=1; number-k > 0 && number+k <= size; k++) {
                    if(array[number+k] == array[number-k]) { // 대칭이면
                        if(array[number+k] == 0) {
                            array[number+k] = 1;
                            array[number-k] = 1;
                        } else {
                            array[number+k] = 0;
                            array[number-k] = 0;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i=1; i<=size; i++) {
            System.out.print(array[i] + " ");
            if(i%20 == 0) System.out.println();
        }
    }

}
