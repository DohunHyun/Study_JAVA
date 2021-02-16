package JGOL1828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static int N;
    static int anwer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        anwer = 0;

        Chemical[] chemicals = new Chemical[N];

        for(int i=0; i<N; i++) {
            chemicals[i] = new Chemical(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(chemicals, new Comparator<Chemical>() {
            @Override
            public int compare(Chemical o1, Chemical o2) {
                return o1.low - o2.low;
            }
        });

        ArrayList<Chemical> list = new ArrayList<>();
        list.add(chemicals[0]);

        outloop : for(int i=1; i<N; i++) {
            Chemical chemical = chemicals[i]; // 새롭게 비교할 친구

            for(int j=0; j<list.size(); j++) {
                Chemical temp = list.get(j); // 이미 비교한 친구
                if(temp.high >= chemical.low) { // 이미 있는애보다
                    if(temp.low >= chemical.low) {

                    } else {
                        temp = chemical;
                    }
                    if(temp.high <= chemical.high) {

                    } else {
                        temp = chemical;
                    }

                    continue outloop;
                }
            }

            list.add(chemical);
        }
        System.out.println(list.size());
    }

    private static class Chemical {
        int low;
        int high;

        public Chemical(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
