package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298_오큰수구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] inputArr = new int[n];
        int[] resultArr = new int[n];

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);

        for(int i=0; i<n-1; i++) {

            while(!stack.isEmpty() && inputArr[stack.peek()] < inputArr[i+1]) {
                resultArr[stack.pop()] = inputArr[i+1];
            }

            stack.push(i+1);
        }

        while(!stack.isEmpty()) {
            resultArr[stack.pop()] = -1;
        }

        for(int i=0; i<n; i++) {
            sb.append(resultArr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
