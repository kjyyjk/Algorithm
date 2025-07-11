package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12348_분해합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long num = Long.parseLong(input);
        long l = num - (input.length() * 9);
        long result = solve(l, num);
        System.out.println(new StringBuilder().append(result));
    }

    private static long solve(long start, long goal) {
        for (long num = start; num <= goal; num++) {
            long sum = num;
            for (char temp : String.valueOf(num).toCharArray()) {
                sum += temp - '0';
            }
            if (sum == goal) {
                return num;
            }
        }
        return 0;
    }
}
