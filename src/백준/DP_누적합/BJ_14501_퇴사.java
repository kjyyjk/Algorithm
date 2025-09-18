package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] result = new int[n + 1];

        int i;
        StringTokenizer st;
        for (i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (i=1; i<n+1; i++) {
            if (i + t[i] < n + 2) { //i일의 작업이 퇴사일 이전에 끝날 경우
                result[i + t[i] - 1] = Math.max(result[i + t[i] - 1], result[i - 1] + p[i]); //작업이 끝나는 날 최댓값 저장
            }

            result[i] = Math.max(result[i-1], result[i]); //전날과 오늘 중 최댓값 저장
        }

        System.out.println(new StringBuilder().append(result[n]));
    }
}
