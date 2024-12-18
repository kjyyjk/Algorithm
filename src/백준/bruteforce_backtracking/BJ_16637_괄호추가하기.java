package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자와 연산자를 따로 보관한다.
 * 인덱스를 유지하며 완전탐색 진행.
 *
 * go(here, num) : 현재 인덱스 here, 현재 인덱스까지 누적합 num
 * 만약 here가 마지막 숫자이면 ret과 누적합 num을 비교하여 ret 갱신 후 종료
 * 아니면 다음 숫자(here + 1)까지 누적합 연산한 다음 다시 재귀호출 go(here + 1, new num)
 * 만약 다다음 숫자가 존재(here + 2)하면 다음 숫자와 다다음 숫자를 먼저 연산한 누적합 연산 한 다음 go(here + 2, new num)
 */
public class BJ_16637_괄호추가하기 {
    static List<Integer> numbers = new ArrayList<>();
    static List<String> opers = new ArrayList<>();
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if ("+-*".contains(str[i])) {
                opers.add(str[i]);
            } else {
                numbers.add(Integer.parseInt(str[i]));
            }
        }

        go(0, numbers.get(0));
        System.out.println(new StringBuilder().append(ret));
    }

    static void go(int here, int num) {
        if (here == numbers.size() - 1) {
            ret = Math.max(ret, num);
            return;
        }
        int temp = cal(num, opers.get(here), numbers.get(here + 1));
        go(here + 1, temp);

        if (here + 2 <= numbers.size() - 1) {
            temp = cal(num, opers.get(here), cal(numbers.get(here + 1), opers.get(here + 1), numbers.get(here + 2)));
            go(here + 2, temp);
        }
    }

    static int cal(int a, String op, int b) {
        if (op.equals("*")) return a * b;
        if (op.equals("+")) return a + b;
        return a - b;
    }
}
