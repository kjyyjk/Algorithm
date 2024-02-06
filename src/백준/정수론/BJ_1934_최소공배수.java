package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1934_최소공배수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a, b;
        StringTokenizer st;
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(a*b/gcd(a, b)).append('\n');
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) { // 유클리드 호제법
        if (b==0) {
            return a;
        }
        return gcd(b, a%b); // 두번째의 mod연산 결과가 0이면 더 작은 b를 반환하게 된다.
    }
}
