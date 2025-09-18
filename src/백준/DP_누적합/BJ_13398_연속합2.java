package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13398_연속합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];

        int i;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        l[0] = a[0];
        r[n-1] = a[n-1];

        int result = a[0];
        for (i=1; i<n; i++) {
            l[i] = Math.max(a[i], l[i-1] + a[i]); //좌 -> 우 방향 i를 포함한 연속 수 합 최대
            result = Math.max(result, l[i]); //삭제하지 않을 시 최대값
        }

        for (i=n-2; i>-1; i--) {
            r[i] = Math.max(a[i], r[i+1] + a[i]); //우 -> 좌 방향 i를 포함한 연속 수 합 최대
        }

        for (i=1; i<n-1; i++) {
            result = Math.max(result, l[i-1] + r[i+1]); //삭제하지 않앗을 때랑 삭제 했을 때 중 더 큰값
        }

        System.out.println(new StringBuilder().append(result));
    }

}
