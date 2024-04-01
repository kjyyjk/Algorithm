package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13251_조약돌꺼내기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int[] rock = new int[m];

        int i;
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (i=0; i<m; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
            total += rock[i];
        }

        int k = Integer.parseInt(br.readLine());

        int j;
        double temp;
        double result = 0;
        for (i=0; i<m; i++) {
            if (rock[i] >= k) {
                temp = 1;

                for(j=0; j<k; j++) {
                    temp = temp * (rock[i] - j) / (total - j);
                }

                result += temp;
            }
        }

        System.out.println(new StringBuilder().append(result));
    }
}
