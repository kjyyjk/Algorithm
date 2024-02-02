package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1456_거의소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];

        int i, j;

        for(i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for (i=2; i<=Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (j=i*2; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        long temp;
        int result = 0;
        for (i=2; i<arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            temp = arr[i];

            while((double)arr[i] <= (double)b/(double)temp) { //이항하지 않으면 long범위 넘어버릴수도 있음
                if((double)arr[i] >= (double)a/(double)temp){
                    result++;
                }
                temp *= arr[i];
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

}
