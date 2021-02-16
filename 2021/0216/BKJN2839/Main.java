package BKJN2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer=0;

        int three=0;
        int five=N/5;


        while(five >= 0) {

            int temp = N - (5*five);

            if(temp%3 == 0) {
                three = temp/3;
                answer = five + three;
                break;
            }

            five--;
            if(five<0 && three == 0) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);


    }
}
