package SWEA3289;

import java.util.Scanner;

public class Solution { // swea 3289. 서로소 집합
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int cycle=1; cycle<=T; cycle++) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            int m = sc.nextInt();
            String ans = "";

            parent = new int[n+1];

            for(int i=1; i<=n; i++) { // 부모 자기로 초기화
                parent[i] = i;
            }

            for(int i=0; i<m; i++) {
                int command = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                int xRoot = find(x);
                int yRoot = find(y);

                if(command == 0) { // 합집합 해라!
                    if(x==y || xRoot == yRoot){

                    } else {
                        parent[yRoot] = xRoot;
                    }

                } else { // 같은 집합이냐!
                    if(x==y || xRoot == yRoot) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }

            System.out.println("#" + cycle + " " + sb.toString());
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
