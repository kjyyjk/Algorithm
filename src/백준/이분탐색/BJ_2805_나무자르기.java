package 백준.이분탐색;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * 구해야하는 건 조건을 만족하는 절단기의 최대 길이.
 * 길이 범위: 0 ~ 1,000,000,000. 각 길이에서 n개 나무와 연산해야함.
 * 완전 탐색으로는 시간 초과.
 *
 * 이분 탐색 시간 복잡도 -> O(1000000 * log(1,000,000,000)) = 30_000_000 좀 안됨. -> 시간 통과
 * 최대 길이를 구하는 것이므로 이분 탐색(upper-bound)하면 된다.
 */
public class BJ_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(st.nextToken());
            if (length > max) max = length;
            trees[i] = length;
        }

        int ret = 0;

        int start = 0;
        int end = max;
        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0; // 나무 하나의 최대 길이가 1,000,000,000이므로 정수 범위를 초과할 수 있음
            for (int i = 0; i < n; i++) {
                int length = trees[i] - mid;
                if (length > 0) { // 나무가 절단기 높이보다 짧을 경우 음수가 더해지는 것을 방지
                    sum += (trees[i] - mid);
                }
            }

            if (sum >= m) {
                ret = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ret);
    }
}
