package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 행, 열을 뒤집거나 안뒤집는 경우의 수는 2^40으로 시간 초과이다.
 * 따라서 시간 복잡도를 줄여야한다.
 *
 * 이미 모든 행이 정해진 상태라면 어떤 열을 뒤집을지는 계산만 하면 된다.
 * 즉, 각 행을 뒤집고 안뒤집는 경우의 수만 고려하고.
 * 열에 대한 것은 해당 경우에서 계산만 하면된다.
 * 예를 들어서
 * HHH
 * THH
 * TTH 로 행이 정해져있다면
 * T의 개수를 최소로 하기 위해서 1열만 뒤집어주면 된다.
 *
 * 따라서 행을 뒤집는 경우의 수만 체크하면 되기 때문에 시간 복잡도는 2^20까지 줄어든다.
 *
 * 각 행에 대해 n <= 20이고 경우의 수를 따지는 문제이다. -> 비트 마스킹을 사용할 수 있겠다.
 * 비트 마스킹을 사용하면 뒤집는 연산 또한 for문 없이 ~num으로 해결된다.
 *
 *
 */
public class BJ_1285_동전뒤집기 {
    static int n, ret;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 4];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'T') {
                    temp = temp | (1 << (s.length() - 1 - j));
                }
            }
            arr[i] = temp;
        }
        ret = 4000;
        go(0);
        System.out.println(new StringBuilder().append(ret));
    }

    static void go(int num) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    sum++;
                }
            }
            cnt += Math.min(sum, n - sum); // i열에 대해 뒤집거나 안뒤집거나의 최소 T 개수를 더한다.
        }
        ret = Math.min(ret, cnt);
        for (int i = num; i < n; i++) { // 행을 뒤집는 모든 경우의 수
            arr[i] = ~arr[i];
            go(i + 1);
            arr[i] = ~arr[i];
        }
    }
}
