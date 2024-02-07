package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1850_최대공약수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long temp = gcd(a, b);

        StringBuilder result = new StringBuilder();
        for (long i=0; i<temp; i++) {
            result.append('1');
        }

        System.out.println(result);
    }

    static long gcd(long a, long b) {
        if (b==0) {
            return a;
        }

        return gcd(b, a%b);
    }

}
