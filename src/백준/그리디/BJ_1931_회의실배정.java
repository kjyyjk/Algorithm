package 백준.그리디;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 길이 n인 arr을 정렬 + 전체 순회
 * O(nlogn) + O(n) = O(nlogn)
 *
 * n<= 100,000
 *
 * O(13 * 00000)
 */
public class BJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(arr, (a, b) ->  {
            if (a[1] == b[1]) { // 종료 시간이 같을 경우 시작 시간 기준 오름차순 정렬
                return a[0] - b[0];
            } else {
                return a[1] - b[1]; // 종료 시간 기준 오름차순 정렬
            }
        });

        int count = 0;
        int prevFinishTime = 0;

        // arr은 이미 빨리 끝나는 순으로 정렬된 상태.
        for (int i = 0; i < n; i++) {
            if (prevFinishTime <= arr[i][0]) { // 이전 확정 회의와 겹치지 않는 경우만
                count++;
                prevFinishTime = arr[i][1];
            }
        }

        System.out.println(count);
    }

}
