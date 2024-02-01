package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1929_소수구하기 {

    public static void main(String[] args) throws IOException {

        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for (i=2; i<n+1; i++) {
            arr[i] = i;
        }

        //에라토스테네스의 채
        for (i=2; i<=Math.sqrt(n); i++) { //n의 제곱근까지만 반복
            if(arr[i] == 0) {
                continue;
            }

            for (j=i*2; j<n+1; j+=i) {
                arr[j] = 0; //arr[i]의 배수 제거
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i=m; i<n+1; i++) {
            if (arr[i]!=0) {
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
