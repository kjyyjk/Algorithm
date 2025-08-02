package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class BJ_1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> priority = Map.of('*', 2, '/', 2, '+', 1, '-', 1, '(', 0);

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { // 피연산자 -> 출력
                sb.append(c);
            } else if (c == '(') { // 열린 괄호 -> 스택 삽입
                stack.push(c);
            } else if (c == ')') { // 닫힌 괄호 -> 열린괄호가 나올 때까지 연산자 출력
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) { // 열린 괄호 pop
                    stack.pop();
                }
            } else { // 연산자
                while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) { // 우선순위가 높거나 같은 연산 먼저 수행
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) { // 남은 연산자 털기
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
