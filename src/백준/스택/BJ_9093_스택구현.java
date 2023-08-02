package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9093_스택구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int t = Integer.parseInt(br.readLine());
        int i, j, k;

        for(i=0; i<t; i++){
            String[] s = br.readLine().split(" ");
            for(j=0; j<s.length; j++){
                for(k=0; k<s[j].length(); k++){
                    stack.push(s[j].charAt(k));
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
