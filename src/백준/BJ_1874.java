package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int i = 1;
        int temp;

        Stack<Integer> stack = new Stack<>();

        while(true) {
            temp = Integer.parseInt(br.readLine());

            while(i<=temp) {
                stack.push(i);
                sb.append('+').append('\n');
                i++;
            }

            if(stack.pop()==temp) {
                sb.append('-').append('\n');
            } else {
                sb = new StringBuilder().append("NO");
                break;
            }

            if(i>n && stack.isEmpty()) {
                break;
            }
        }

        System.out.println(sb);
    }

}
