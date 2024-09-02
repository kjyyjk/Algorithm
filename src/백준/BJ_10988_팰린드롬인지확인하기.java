package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10988_팰린드롬인지확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String reverse = new StringBuilder(input).reverse().toString();

        StringBuilder result = new StringBuilder();
        if (input.equals(reverse)) {
            result.append(1);
        } else {
            result.append(0);
        }

        System.out.println(result);
    }
}