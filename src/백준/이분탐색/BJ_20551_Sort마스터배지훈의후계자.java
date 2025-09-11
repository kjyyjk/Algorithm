package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BJ_20551_Sort마스터배지훈의후계자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int index = findIndex(arr, num);
            sb.append(index).append('\n');
        }
        System.out.println(sb);
    }

    /**
     * lower-bound 알고리즘
     * 특정 값이 처음 등장하는 위치 찾기 (반대는 upper-bound 알고리즘)
     *
     * 찾았더라도 index를 바로 return 하지 않고 계속 탐색한다.
     * 처음 나온 위치면 index가 더 작아야함.
     * arr[mid] < target이면 start = mid + 1;
     * arr[mid] >= target이면 end = mid - 1;
     *
     * 마지막엔 -1이거나 처음 등장한 위치
     */
    static int findIndex(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;

        int ret = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) {
                ret = mid; // 바로 return 하지 않고 while이 종료될 때까지 탐색
            }

            if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ret;
    }
}
