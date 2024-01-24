package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1427_소트인사이드 {

    public static void main(String[] args) throws IOException {

        int i, j, maxInd, temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int[] arr = new int[n.length()];

        for(i=0; i<n.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
        }

        for(i=0; i<arr.length-1; i++) {
            maxInd = i;
            for(j=i; j<arr.length; j++) {
                if(arr[j] > arr[maxInd]) {
                    maxInd = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;
        }

        for(i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);

    }
}
