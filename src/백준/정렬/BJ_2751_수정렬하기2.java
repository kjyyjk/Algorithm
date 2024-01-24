package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2751_수정렬하기2 {
    static int[] arr, tempArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[n];
        tempArr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n-1);

        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void mergeSort(int s, int e) {
        if(e-s < 1) {
            return;
        }

        int m = (e+s)/2;

        mergeSort(s,m);
        mergeSort(m+1,e);

        int i, j;

        for(i=s; i<e+1; i++) {
            tempArr[i] = arr[i];
        }

        int arrInd = s;
        i = s;
        j = m+1;

        while(i<m+1 && j<e+1) {
            if(tempArr[i] > tempArr[j]) {
                arr[arrInd++] = tempArr[j++];
            } else if (tempArr[i] < tempArr[j]) {
                arr[arrInd++] = tempArr[i++];
            }
        }

        while(i<m+1) {
            arr[arrInd++] = tempArr[i++];
        }

        while(j<e+1) {
            arr[arrInd++] = tempArr[j++];
        }

    }
}
