package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 수 A, B
 * 최대 공약수 x
 * 최소 공배수 y
 *
 * A = x * a
 * B = x * b
 * y = x * a * b
 *
 * A * B =  x * x * a * b
 * A * B = x * y
 *
 * 두 수의 곱은 최대 공약수와 최소 공배수의 곱과 같다.
 */
public class BJ_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ret1 = 0; // 최대 공약수
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if ((a % i == 0) && (b % i == 0) && ret1 < i) {
                ret1 = i;
            }
            int other = a/i;
            if ((a % other == 0) && (b % other == 0) && ret1 < other) {
                ret1 = other;
            }
        }
        int ret2 = (a * b) / ret1; // 최대 공배수

        StringBuilder sb = new StringBuilder();
        sb.append(ret1).append('\n');
        sb.append(ret2).append('\n');
        System.out.println(sb);
    }
}
