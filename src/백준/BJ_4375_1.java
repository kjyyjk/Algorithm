package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_4375_1 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            n = Integer.parseInt(input);
            sb.append(recursion(BigInteger.ONE, BigInteger.ONE)).append('\n');
        }

        System.out.println(sb);
    }

    static BigInteger recursion(BigInteger num, BigInteger size) {
        if (num.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
            return size;
        }

        return recursion(num.multiply(BigInteger.TEN).add(BigInteger.ONE), size.add(BigInteger.ONE));
    }
}
