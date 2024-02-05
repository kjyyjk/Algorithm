package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11689_GCD {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long result = n;
        long temp = n;

        for (int i=2; i<=Math.sqrt(n); i++) {
            if (temp%i == 0) { // 소인수이면
                result = result - result/i;

                while(temp%i == 0) { // temp에서 계산 끝난 소인수 제거
                    temp = temp/i;
                }
            }
        }

        if(temp > 1) { // 소인수가 남아있으면
            result = result - result/temp;
        }

        System.out.println(new StringBuilder().append(result));
    }

}
