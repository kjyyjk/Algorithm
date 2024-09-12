package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈 {
    static long a;
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(recursion(b));

        System.out.println(sb);
    }

    static long recursion(long exp) {
        if (exp == 1) {
            return a % c;
        }

        if (exp%2 == 1) {
            long temp = recursion((exp-1) / 2);
            return (((temp * temp) % c) * (a % c)) % c;
        } else {
            long temp = recursion(exp / 2);
            return (temp * temp) % c;
        }
    }
}
