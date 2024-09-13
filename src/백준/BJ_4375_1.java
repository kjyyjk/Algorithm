package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4375_1 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            n = Integer.parseInt(input);
            sb.append(recursion(1, 1)).append('\n');
        }

        System.out.println(sb);
    }

    static int recursion(long num, int size) {
        if (num % n == 0) {
            return size;
        }

        return recursion(((num % n) * (10 % n)) + 1, size + 1);
    }
}
