package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_16637_괄호추가하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for (int i = n - 1; i > -1; i--) {
            stack.push(str[i]);
        }

        int ret = solve(stack);
        System.out.println(new StringBuilder().append(ret));
    }

    static int solve(Stack<String> stack) {
        if (stack.size() == 1) {
            return Integer.parseInt(stack.peek());
        }
        int ret = Integer.MIN_VALUE;
        int n1 = Integer.parseInt(stack.pop());
        String op1 = stack.pop();
        int n2 = Integer.parseInt(stack.pop());

        stack.push(String.valueOf(cal(n1, op1, n2)));
        ret = Math.max(ret, solve(stack));
        stack.pop();
        if (stack.size() != 0) {
            String op2 = stack.pop();
            int n3 = Integer.parseInt(stack.pop());
            stack.push(String.valueOf(cal(n1, op1, cal(n2, op2, n3))));
            ret = Math.max(ret, solve(stack));
            stack.pop();
            stack.push(String.valueOf(n3));
            stack.push(op2);
        }
        stack.push(String.valueOf(n2));
        stack.push(op1);
        stack.push(String.valueOf(n1));
        return ret;
    }

    static int cal(int a, String op, int b) {
        int result = 0;
        switch (op) {
            case ("+") :
                result = a + b;
                break;
            case ("-") :
                result = a - b;
                break;
            case ("*") :
                result = a * b;
                break;
        }
        return result;
    }
}
