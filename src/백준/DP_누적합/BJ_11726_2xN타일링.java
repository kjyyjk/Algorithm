package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726_2xN타일링 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n+2];
        d[1] = 1;
        d[2] = 2;

        for (int i=3; i<n+1; i++) {
            d[i] = ((d[i-1] % 10007) + (d[i-2] % 10007)) % 10007;
        }

        System.out.println(new StringBuilder().append(d[n]));
    }

}
