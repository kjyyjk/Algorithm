package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * go() 재귀함수에 길이 총합, 막대 개수, 가장 짧은 막대 길이를 인자로 전달한다.
 * 만약 총합이 입력받은 x와 같다면 막대 개수를 반환한다.
 *
 * 만약 가장 짧은 막대를 절반으로 나누어 한쪽을 버린 길이가 x보다 크거나 같으면 한 쪽을 버리고 다시 재귀 호출한다. 길이 총합이 감소한다.
 * x보다 작다면 버리지 않고 다시 재귀 호출을 한다. 막대 개수는 1 증가한다.
 */
public class BJ_1094_막대기 {
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        int ret = go(64, 1, 64);
        System.out.println(new StringBuilder().append(ret));
    }

    static int go(int total, int cnt, int s) {
        if (total == x) {
            return cnt;
        }
        if (total - (s / 2) >= x) {
            return go(total - (s / 2), cnt, s / 2);
        } else {
            return go(total, cnt + 1, s / 2);
        }
    }
}
