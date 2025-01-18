package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * x <= 20이고 x의 상태가 유(1)또는 무(0)이므로 비트마스킹으로 접근할 수 있다.
 *
 * add x : x번째 비트 켜기
 * remove x : x번째 비트 끄기
 * check x : x번째 비트 상태 확인 및 출력
 * toggle x : x번째 비트 XOR 연산
 * all : 1 ~ 20번째의 모든 비트 켜기
 * empty : 1 ~ 20번째의 모든 비트 끄기
 */
public class BJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        int num = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int idx = Integer.parseInt(st.nextToken());
                num |= (1 << idx);
            } else if (command.equals("remove")) {
                int idx = Integer.parseInt(st.nextToken());
                num &= ~(1 << idx);
            } else if (command.equals("check")) {
                int idx = Integer.parseInt(st.nextToken());
                if ((num & (1 << idx)) != 0) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("toggle")) {
                int idx = Integer.parseInt(st.nextToken());
                num ^= (1 << idx);
            } else if (command.equals("all")) {
                num = (1 << 21) - 1;
            } else {
                num = 0;
            }
        }
        System.out.println(sb);
    }
}
