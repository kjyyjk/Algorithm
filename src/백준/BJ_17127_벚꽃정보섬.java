package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17127_벚꽃정보섬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n - 3; i++) { // 첫 번째 구간의 마지막 나무 인덱스
            for (int j = i + 1; j < n - 2; j++) { // 두 번째 구간의 마지막 나무 인덱스
                for (int k = j + 1; k < n - 1; k++) { // 세 번째 구간의 마지막 나무 인덱스
                    int sum = cal(arr, 0, i) + cal(arr, i + 1, j) + cal(arr, j + 1, k) + cal(arr, k + 1, n - 1);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(new StringBuilder().append(max));
    }

    public static int cal(int[] arr, int s, int e) {
        int ret = 1;
        for (int i = s; i < e + 1; i++) {
            ret *= arr[i];
        }
        return ret;
    }
}
