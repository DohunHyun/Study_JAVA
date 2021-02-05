package SWEA1223;

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int cycle=1; cycle<=10; cycle++) {
            int length = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<length; i++) { // 변환 시작!
                if(input.charAt(i) == '+' || input.charAt(i) == '*') {
                    if(stack.isEmpty()) { // 스택이 비어있다. 푸쉬.
                        stack.push(input.charAt(i));
                    } else { // 스택이 안비어있다. 관계 따지기
                        if(input.charAt(i) == '*') { // *이니깐 푸쉬!
                            if(stack.peek() == '*') { // 이미 있는게 *이면 우선순위가 같으니까 팝해서 붙여주고 푸쉬.
                                sb.append(stack.pop());
                                stack.push(input.charAt(i));
                            } else { // 스택안에 + 가 있을때, 즉 우선순위가 더 높다. 그냥 푸쉬
                                stack.push(input.charAt(i));
                            }
                        } else { // +일때 무조건 우선순위가 같거나 높다. 즉 팝해서 붙여주고 푸쉬
                            while(!stack.isEmpty()) {
                                sb.append(stack.pop());
                            }
                            stack.push(input.charAt(i));
                        }
                    }

                } else { // 숫자일때
                    sb.append(input.charAt(i));
                }
            }

            while(!stack.isEmpty()) { // 스택에 남은애들 붙여주기
                sb.append(stack.pop());
            }


            // 후위표기식으로 전환 끝
            String postfix = sb.toString();
            sb.delete(0,sb.length());
            Stack<Integer> calcStack = new Stack<>();
            //계산 시작!

            for(int i=0; i<postfix.length(); i++) {
                if(postfix.charAt(i) == '+' || postfix.charAt(i) == '*') {
                    int second = calcStack.pop();
                    int first = calcStack.pop();
                    int temp;
                    if(postfix.charAt(i) == '+') {
                        temp = first + second;
                    } else {
                        temp = first * second;
                    }
                    calcStack.push(temp);
                } else {
                    calcStack.push(postfix.charAt(i)-'0');
                }
            }

            System.out.println("#" + cycle + " " + calcStack.peek());

        }



    }
}
