package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결국 x를 인지수로 나타내었을 때 1의 개수를 구해야하는 문제이다.
 * 따라서 x를 인지수로 변환하는 과정에서 1의 개수를 세고 출력한다.
 * x가 여러번 나누어져서 되는 1까지 고려하기 위해 ret을 초기에 1로 초기화한다.
 */
public class BJ_1094_막대기 {
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        int ret = 1;
        while (x > 1) {
            if (x % 2 == 1) {
                ret++;
            }
            x /= 2;
        }
        System.out.println(new StringBuilder().append(ret));
    }
}
