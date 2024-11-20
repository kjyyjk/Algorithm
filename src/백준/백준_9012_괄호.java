package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if (check(s)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(String s) throws IOException {
        Stack<String> stack = new Stack<>();
        for (String c : s.split("")) {
            if (c.equals("(")) {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
