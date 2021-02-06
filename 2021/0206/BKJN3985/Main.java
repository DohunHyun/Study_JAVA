package BKJN3985;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cakeLength = sc.nextInt();
        int[] cakeArray = new int[cakeLength+1]; //인덱스 맞추기 위해 0 사용안함
        int numofPeople = sc.nextInt();
        int[] expectCake = new int[numofPeople+1];
        int[] realCake = new int[numofPeople+1];

        for(int cycle=1; cycle<=numofPeople; cycle++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            expectCake[cycle] = end-start+1;

            for(int i=start; i<=end; i++) {
                if(cakeArray[i] == 0) { // 안채워져있을때만 채우기
                    cakeArray[i] = cycle; // 0부터 시작하니까
                }
            }
        }

        int maxExpectPeople = 0;
        int maxExpectCake = 0;
        for(int i=1; i<expectCake.length; i++) {
            if(expectCake[i] > maxExpectCake) {
                maxExpectPeople = i;
                maxExpectCake = expectCake[i];
            }
        }

        for(int i=0; i<cakeArray.length; i++) {
            realCake[cakeArray[i]]++;
        }

        int maxCakePeople = 0;
        int maxCake = 0;
        for(int i=1; i<realCake.length; i++) {
            if(realCake[i] > maxCake) {
                maxCakePeople = i;
                maxCake = realCake[i];
            }
        }

        System.out.println(maxExpectPeople);
        System.out.println(maxCakePeople);
    }
}
