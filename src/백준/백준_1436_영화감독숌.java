package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = 666;
        for (; ; i++) {
            if (String.valueOf(i).contains("666")) {
                n--;
            }
            if (n == 0) {
                break;
            }
        }

        System.out.println(new StringBuilder().append(i));
    }
}
