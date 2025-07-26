package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 약수의 개수가 짝수이면 닫힌 창문, 약수의 개수가 홀수이면 열린 창문
 * 약수의 개수가 홀수인 수 -> x^2로 표현될 수 있는 제곱수
 * 즉 범위 내 제곱수의 개수를 구하면된다.
 * 범위 내 제곱수의 개수 = (1 ~ 최대 수의 제곱근) 범위의 정수 개수.
 */
public class BJ_13909_창문닫기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = (int) Math.sqrt(n);
        System.out.println(new StringBuilder().append(cnt));
    }
}
