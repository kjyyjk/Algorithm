package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9093_스택구현2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i;
        int t = Integer.parseInt(br.readLine());

        for(i=0; i<t; i++){
            String s = br.readLine() + '\n';
            for(char c : s.toCharArray()){
                if(c == '\n' || c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }
                else{
                    stack.push(c);
                }
            }
        }
        System.out.println(sb);
    }
}