package SWEA1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int cycle = 1; cycle<=10; cycle++) {
            int size = Integer.parseInt(br.readLine());
            String sentence = br.readLine();
            Stack<Character> stack = new Stack();

            int answer = 0;

            for(int i=0; i<size; i++) {
                char temp = sentence.charAt(i);

                if(temp == ')' && stack.peek() == '(' ) {
                    stack.pop();
                } else if(temp == '}' && stack.peek() == '{' ) {
                    stack.pop();
                } else if(temp == ']' && stack.peek() == '[' ) {
                    stack.pop();
                } else if (temp == '>' && stack.peek() == '<' ) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }

            if(stack.isEmpty()) {
                answer = 1;
            } else {
                answer = 0;
            }

            System.out.println("#" + cycle + " " + answer);


        }
    }
}
