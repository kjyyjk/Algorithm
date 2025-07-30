package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String input = br.readLine();

        int result = 0;
        String prev = "(";
        for (String s : input.split("")) {
            if (s.equals(")")) {
                if (prev.equals("(")) { // 레이저
                    stack.pop();
                    result += stack.size();
                } else { // 막대 끝
                    stack.pop();
                    result++;
                }
            } else { // 막대 추가
                stack.push(s);
            }
            prev = s;
        }
        System.out.println(new StringBuilder().append(result));
    }
}

