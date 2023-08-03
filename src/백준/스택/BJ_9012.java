package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        char[] arr;
        int cnt;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            stack = new Stack<>();
            arr = br.readLine().toCharArray();
            cnt = arr.length;
            for (char c : arr) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
                cnt--;
            }

            if (!stack.isEmpty() || cnt != 0) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }

        System.out.println(sb);
    }
}
