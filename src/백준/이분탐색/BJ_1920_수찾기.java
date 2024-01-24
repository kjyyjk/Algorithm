package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {

    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        int n, m, i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(num, 0, n-1);
        }

        System.out.println(sb);
    }

    static void binarySearch(int num, int s, int e) {
        if(e<s) {
            sb.append("0\n");
            return;
        }

        int mid = (s+e)/2;

        if(num == arr[mid]) {
            sb.append("1\n");
            return;
        } else if (num > arr[mid]) {
            binarySearch(num, mid+1, e);
        } else {
            binarySearch(num, s, mid-1);
        }
    }
}
