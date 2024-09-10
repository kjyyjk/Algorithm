package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1940_주몽2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;

        if (m > 200000) {
            System.out.println(new StringBuilder().append(ret));
        } else {
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    if (arr[i] + arr[j] == m) {
                        ret++;
                    }
                }
            }
            System.out.println(new StringBuilder().append(ret));
        }
    }
}
