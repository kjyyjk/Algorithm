package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11655_ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c+13 > 'z') {
                    result.append((char)(c+13-26));
                } else {
                    result.append((char)(c+13));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c+13 > 'Z') {
                    result.append((char)(c+13-26));
                } else {
                    result.append((char)(c+13));
                }
            } else {
                result.append(c);
            }
        }

        System.out.println(result);
    }
}
