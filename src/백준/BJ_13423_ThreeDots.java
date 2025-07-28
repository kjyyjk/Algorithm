package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 3 <= N <= 1_000
 *
 * 모든 경우의 수 = O(n^3) -> 시간 초과
 * a, b를 고정하고 다른 c는 이분 탐색 -> O(n^2 * log(n)) -> 통과
 */
public class BJ_13423_ThreeDots {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    int k = (2 * arr[j]) - arr[i];
                    int ind = Arrays.binarySearch(arr, j + 1, n, k);
                    if (ind >= 0) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
