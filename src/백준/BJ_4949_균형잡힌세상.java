package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s;
        while(!(s = br.readLine()).equals(".")) {
            if (check(s)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean check(String s) {
        Stack<String> stack = new Stack<>();
        for (String c : s.split("")) {
            if (c.equals("[") || c.equals("(")) {
                stack.push(c);
            } else if (c.equals("]")) {
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c.equals(")")) {
                if (stack.isEmpty() || stack.peek().equals("[")) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
