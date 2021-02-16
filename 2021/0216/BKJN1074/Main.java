package BKJN1074;

import java.util.Scanner;

public class Main {
    static int N;
    static int r;
    static int c;
    static int size;
    static int temp;
    static int x, y;
    static int[][] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         N = sc.nextInt();
         r = sc.nextInt();
         c = sc.nextInt();
         temp = 0;
         size = (int)Math.pow(2,N);

        System.out.println(size);

        if(N>1) {

        } else {
            array = new int[size][size];

//            draw();





        }
    }

    private static void draw(int depth, int count) {
        if(temp == size) {
            return;
        }

        x += (int)Math.pow(2,count);

        array[x][y] = temp++;
        array[x][y+1] = temp++;
        array[x+1][y] = temp++;
        array[x+1][y+1] = temp++;


        draw(depth+1, count+1);
    }
}
