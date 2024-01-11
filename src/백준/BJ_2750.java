package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int i, j, temp;
        boolean swap;

        for(i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(i=0; i<n-1; i++) {
            swap = true;
            for(j=0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = false;
                }
            }

            if(swap) { //안쪽 반복문에서 한번도 swap을 하지 않았을 경우 정렬 끝
                break;
            }
        }

        for(i=0; i<n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
