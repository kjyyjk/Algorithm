package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1517_버블소트 {

    static int[] arr, tempArr;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        tempArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(0, n-1);

        System.out.println(new StringBuilder().append(result));
    }

    static void mergeSort(int s, int e) {
        if(e-s<1) {
            return;
        }

        int m = (s+e)/2;

        mergeSort(s, m);
        mergeSort(m+1, e);

        int i, j, k;

        for(i=s; i<e+1; i++) {
            tempArr[i] = arr[i];
        }

        i=s;
        j=m+1;
        k=s;

        while(i<m+1 && j<e+1) {
            if(tempArr[i] > tempArr[j]) {
                result += m-i+1;
                arr[k++] = tempArr[j++];
            }
            else {
                arr[k++] = tempArr[i++];
            }
        }

        while(i<m+1) {
            arr[k++] = tempArr[i++];
        }

        while(j<e+1) {
            arr[k++] = tempArr[j++];
        }
    }

}
