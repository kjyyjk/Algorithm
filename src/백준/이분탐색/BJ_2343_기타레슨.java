package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2343_기타레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m, i, s, e, mid;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        int total = 0;
        int max = 0;

        for(i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //블루레이의 크기를 이분탐색
        s = max;
        e = total;

        while(s<=e) {
            mid = (s+e)/2;
            int cnt = 0;
            int sum = 0;

            for(i=0; i<n; i++) { // 해당 블루레이 크기(mid)로 필요한 블루레이 수 구하기
                sum += arr[i];
                if(sum > mid) {
                    cnt++;
                    sum = arr[i];
                }
            }

            if(sum != 0) {
                cnt++;
            }

            if(cnt > m) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(new StringBuilder().append(s)); //s>e 가 되면 s가 정답(최소크기)
    }

}
