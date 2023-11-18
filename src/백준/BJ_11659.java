package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659 {

    public static void main(String[] args) throws IOException {

        int i, j, t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //배열 arr과 구간 합 배열 arrSum 선언 및 0번 인덱스 값 0으로 초기화
        int[] arr = new int[n+1];
        int[] arrSum = new int[n+1];
        arr[0] = 0;
        arrSum[0] = 0;

        // arr과 arrSum 값 채우기
        st = new StringTokenizer(br.readLine(), " ");
        for(t=1; t<n+1; t++) {

            arr[t] = Integer.parseInt(st.nextToken());
            arrSum[t] = arrSum[t-1] + arr[t];
        }

        //각 구간합 구하기
        for(t=0; t<m; t++) {

            st = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sb.append(arrSum[j] - arrSum[i - 1]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
