package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 연속하는 올바른 문자열의 최대 길이를 구해야한다.
 * 따라서 배열을 활용해 올바른 문자열들을 1로 표시하고, 연속되는 1의 최대 길이를 구한다.
 *
 * stack으로 인덱스를 관리한다.
 * (가 나오면 스택에 해당 인덱스를 push한다.
 * 만약 )가 나왔을 때 스택이 비어있다면. 올바르지 않은 수임으로 표시하지 않고 넘어간다.
 * 만약 )가 나왔을 때 스택이 비어있지 않다면, 해당 인덱스와 스택의 peek 인덱스가 올바른 문자열 쌍이므로 두 인덱스에 1을 표시한다.
 * 배열의 기본 값은 0이기 때문에 결국 올바른 문자열은 1, 올바르지 않은 문자열은 0으로 표기된다.
 * ex)
 * ()((()) -> 1101111 이 된다.
 *
 * 모든 표시가 끝나면 연속되는 1의 최대 개수를 구하고 출력한다.
 */
public class BJ_15926_현욱은괄호왕이야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n + 4];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    arr[i] = 1;
                    arr[stack.pop()] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            ret = Math.max(ret, cnt);
        }
        System.out.println(new StringBuilder().append(ret));
    }
}
