package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, temp, num, popNum;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        num=1;

        for(i=0; i<n; i++) {
            temp = Integer.parseInt(br.readLine());

            if(temp > num-1) {
                while(temp > num-1) {
                    stack.push(num++);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
            }

            else {
                if(temp < stack.pop()) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                else { // 이 경우는 pop한 수가 temp랑 같을 경우. 작을 경우는 이론상 말이 안됨
                    sb.append('-').append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
