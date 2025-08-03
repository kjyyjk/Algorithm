package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

/**
 * 피연산자는 바로 출력,
 *
 * 후위 표기식에서는 우선순위가 높거나, 같지만 먼저 등장한 것이 먼저 출력됨
 * -> 연산자는 stack.push 하는데, peek의 우선순위가 더 높다면 pop후 출력
 *
 * 열린 괄호는 그대로 push
 *
 * 하나의 괄호쌍은 하나의 피연산자라고 볼 수 있다.
 * 닫힌 괄호가 등장하면 열린 괄호가 등장할 때까지 출력
 * 내부에는 이미 현재까지의 룰이 적용되어 잘 표기되어 있음.
 */
public class BJ_1918_후위표기식 {

    static Map<Character, Integer> priority = Map.of('*', 2, '/', 2, '+', 1, '-', 1, '(', 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
