package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int result = 0;
        int sum;
        int sPointer = 0;
        int ePointer = n-1;

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬 O(nlogn)
        Arrays.sort(arr);


        while(sPointer<ePointer) {
            sum = arr[sPointer] + arr[ePointer];

            if(sum < m) {
                sPointer++;
            } else if (sum > m) {
                ePointer--;
            } else {
                result++;
                sPointer++;
                ePointer--;
            }
        }

        System.out.println(new StringBuilder().append(result).append('\n'));
        br.close();
    }
}
