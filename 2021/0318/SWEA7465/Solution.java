package SWEA7465;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static int N;
    static int[] parent;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int cycle=1; cycle<=T; cycle++) {
            N = sc.nextInt();
            int M = sc.nextInt();
            ans = 0;
            parent = new int[N+1];

            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            for(int i=0; i<M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int rootX = find(x);
                int rootY = find(y);

                if(rootX == rootY){

                } else {
                    parent[rootY] = rootX;
                }
            }

            Map<Integer, Integer> map = new HashMap<>();

            for(int i=1; i<=N; i++) {
               if(map.containsKey(parent[find(i)])) {

               } else {
                   map.put(parent[find(i)], 1);
                   ans++;
               }
            }

            System.out.println("#" + cycle + " " + ans);
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
