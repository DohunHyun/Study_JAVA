package BKJN1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int[] list = new int[X+1];
        int count = 0;

        list[1] = 1;

        for(int i=2; i<=X; i++) {
            int temp = i;
            count = 0;
            while(list[temp] == 0) {
                count++;
                if(temp%3 == 0) {
                    if(list[temp-1] >= list[temp/3]) {
                        temp = temp/3;
                    }
                } else if(temp%2 == 0) {
                    if(list[temp-1] >= list[temp/2]) {
                        temp = temp/2;
                    } else {
                        temp -= 1;
                    }
                } else {
                    temp -= 1;
                }
            }
            if(temp == 1) list[i] = count;
            else list[i] = count + list[temp];
        }

        System.out.println(list[X]);

    }
}
