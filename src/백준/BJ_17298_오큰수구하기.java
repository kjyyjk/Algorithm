package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 시간 복잡도로 인해 이중 for문 무식하게는 안된다.
 * 짝짓기 -> 스택
 * 오큰수가 나오지 않으면 스택에 보관하고 있다가
 * 오큰수가 나오면 스택에서 꺼내고 오큰수를 저장한다.
 */
public class BJ_17298_오큰수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ret = new int[n+4];

        Arrays.fill(ret, -1);

        int[] input = new int[n+4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                ret[stack.peek()] = input[i];
                stack.pop();
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ret[i]).append(' ');
        }
        System.out.println(sb);
    }
}