package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i, n;
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(arr, 5);

        StringBuilder sb = new StringBuilder();
        for(i=0; i<n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void radixSort(int[] arr, int max) {
        int i, j, k;
        int[] output = new int[arr.length];
        int[] bucket;

        k=1;
        for(i=0; i<max; i++) { //각 자릿수
            bucket = new int[10]; //각 자릿수의 분포(0~9)를 담을 bucket
            for(j=0; j<arr.length; j++) {
                bucket[(arr[j]/k)%10]++; //각 자릿수 분포 담기
            }

            for(j=1; j<10; j++) {
                bucket[j] += bucket[j-1]; //bucket을 구간합배열로
            }

            for(j=arr.length-1 ; j>=0; j--) { //뒤에서부터. 10의 자리부터는 앞 자리들을 기준으로 오름차순 되어있기 때문
                output[bucket[(arr[j]/k)%10]-1] = arr[j]; //bucket의 해당 자릿수 값이 n이면, 그 수는 n번째수. 인덱스로는 n-1.
                bucket[(arr[j]/k)%10]--; //자릿수의 값이 같은 다른 수를 고려하여 -1. 해당 자릿수가 같아도 앞자릿수가 더 큰 수가 먼저 뒤로 들어감
            }

            for(j=0; j<arr.length; j++) {
                arr[j] = output[j];
            }

            k*=10; //자릿수 증가
        }
    }
}
