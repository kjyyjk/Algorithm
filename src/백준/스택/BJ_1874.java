package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874 {

    public static void main(String[] args) throws IOException {
        
        int n, cnt, input, top, i;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(0);  //1에서 pop 한 뒤 peek() 사용시 에러를 막고자 초기에 0을 넣어주었다.

        stack.push(1); //1은 무조건 push해야하므로 초기에 넣어두었다.
        sb.append("+\n");

        cnt = 1;  //cnt는 마지막으로 push한 값을 의미

        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            input = Integer.parseInt(br.readLine());
            top = stack.peek();

            if (top < input) {    //top보다 큰 값이 들어온 경우 cnt와 값을 비교하여 push하고, 마지막에 pop을 해준다.
                for(i=cnt; i<input; i++){
                    stack.push(++cnt);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append("-\n");
            } else if(top == input){  //top과 같은 값이 들어온경우 pop을 해준다.
                stack.pop();
                sb.append('-').append('\n');
            }
            else{  //그 외는 top보다 작은수가 들어온 상황인데 오름차순으로 stack에 저장되기에 문제 규칙상 불가..! while문 종료
                break;
            }
        }

        if(n!=-1){  //while문이 중간에 끝났을 경우
            System.out.println("NO");
        } else {  //while문이 끝까지 돌고 끝난경우
            System.out.println(sb);
        }
    }
}