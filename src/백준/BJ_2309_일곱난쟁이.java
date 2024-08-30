package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        int i, j;
        int a = -1;
        int b = -1;
        int total = 0;
        int[] arr = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        for (i=0; i<9; i++) {
            for (j=i+1; j<9; j++) {
                if (total - arr[i] - arr[j] == 100) {
                    a = arr[i];
                    b = arr[j];
                }
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (i=0; i<9; i++) {
            if (arr[i] != a && arr[i] != b) {
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
