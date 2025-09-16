package 백준.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

/**
 * 덜 걸리는 사람이 먼저 하는게 낫다.
 * A < B일때
 * A -> B 순서이면 A + A + B이지만
 * B -> A 순서이면 B + B + A다.
 * A -> B < B -> A 이므로 인출 시간으로 오름차순 정렬 및 합.
 *
 * 정렬 nlogn + 합 n -> O(nlogn)
 */
public class BJ_11399_ATM {
    public static void main(String[] args) throws IOException {

        // n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // array 선언
        List<Integer> times = new ArrayList<>();

        // 인출 시간 입력 및 array 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬
        times.sort(null);

        // 순회하며 합
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int now = prev + times.get(i);
            sum += now;
            prev = now;
        }

        System.out.println(sum);
    }
}
