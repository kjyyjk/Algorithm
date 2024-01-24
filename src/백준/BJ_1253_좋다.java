package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        int i;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long temp;
        long sum;
        int sPointer;
        int ePointer;
        int result = 0;

        for(i=0; i<n; i++) {
            temp = arr[i];
            sPointer = 0;
            ePointer = n-1;

            while(sPointer < ePointer) {

                sum = arr[sPointer] + arr[ePointer];
                if(temp == sum) {
                    if(sPointer!=i && ePointer!=i) { //자기 자신을 제외한 두 수의 합이어야한다
                        result++;
                        break;
                    } else if(ePointer == i) {
                        ePointer--;
                    } else if(sPointer == i) {
                        sPointer++;
                    }
                } else if(temp < sum) {
                    ePointer--;
                } else {
                    sPointer++;
                }
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

}
