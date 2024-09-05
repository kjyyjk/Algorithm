package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_수열 {
    public static void main(String[] args) throws IOException {

        int ret = -100 * 100000 - 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] t = new int[n+1];
        int[] psum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1] + t[i];
        }

        for (int i=k; i<n+1; i++) {
            ret = Math.max(ret, psum[i] - psum[i - k]);
        }

        System.out.println(new StringBuilder().append(ret));
    }
}
