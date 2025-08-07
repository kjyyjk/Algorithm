package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int start = 0;
        int end = 0;
        int sum = arr[start];

        while (start <= end) {
            if (sum == m) { // 같으면 카운트
                cnt++;
                if (end == n - 1) { // 더 추가할게 없으면 종료
                    break;
                }
                sum -= arr[start++];
                sum += arr[++end];
            } else if (sum < m) { // 작으면 추가
                if (end == n - 1) { // 더 추가할게 없으면 종료
                    break;
                }
                sum += arr[++end];
            } else { // 크면 빼기
                if (start == end) { // 이 분기가 없으면 start가 end보다 앞서며 반복이 일찍 끝나버림
                    if (end == n - 1) { // 더 추가할게 없으면 종료
                        break;
                    }
                    sum += arr[++end];
                }
                sum -= arr[start++];
            }
        }
        System.out.println(cnt);
    }
}
