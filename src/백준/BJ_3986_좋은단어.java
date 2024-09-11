package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ret = 0;

        String word;
        Stack<Character> stack;
        for (int i=0; i<n; i++) {
            word = br.readLine();
            stack = new Stack<>();
            for (int j=0; j<word.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(word.charAt(j));
                    continue;
                }

                if (stack.peek() != word.charAt(j)) {
                    stack.push(word.charAt(j));
                    continue;
                }

                stack.pop();
            }

            if (stack.isEmpty()) {
                ret++;
            }
        }

        System.out.println(new StringBuilder().append(ret));
    }
}
