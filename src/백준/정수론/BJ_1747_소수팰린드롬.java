package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1747_소수팰린드롬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i, j;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10000001];

        for (i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for (i=2; i<=Math.sqrt(arr.length); i++) {
                if (arr[i]==0) {
                    continue;
                }

                for(j=2*i; j<arr.length; j+=i) {
                    arr[j]=0;
                }
        }

        int result = 0;
        for (i=n; i<arr.length; i++) {
            if(arr[i]==0) {
                continue;
            }

            if(check(arr[i])) {
                result = arr[i];
                break;
            }
        }

        System.out.println(new StringBuilder().append(result));

    }

    static boolean check(int num) {
        String s = Integer.toString(num);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
