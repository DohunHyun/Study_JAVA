package BKJN1464;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bfs {
    static int N;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = Integer.MAX_VALUE;

        bfs(N, 0);
        System.out.println(ans);
    }

    private static void bfs(int n, int count) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(n, count));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.n == 1) {
                ans = node.count;
                break;
            } else {
                if(node.n % 3 == 0) {
                    queue.add(new Node(node.n/3, node.count+1));
                }
                if(node.n % 2 == 0) {
                    queue.add(new Node(node.n/2, node.count+1));
                }
                queue.add(new Node(node.n-1, node.count+1));

            }
        }
    }

    static class Node {
        int n;
        int count;

        Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
