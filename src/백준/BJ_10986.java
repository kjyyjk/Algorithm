package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, temp;
        long result = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arrSum = new long[n+1];
        long[] remainderArr = new long[m];

        st = new StringTokenizer(br.readLine(), " ");

        // 구간합배열 계산
        for(i=1; i<n+1; i++) {
            arrSum[i] = arrSum[i-1] + Long.parseLong(st.nextToken());
        }

        // 구간합배열에 %m연산
        // 이때 값이 0이면 (1,i)구간이 정답케이스라는 것이므로 result 1 증가
        // %m연산한 후 같은 값을 가지는 구간도 역시 정답케이스. 경우의수 계산을 위해 각 값을 인덱스로 가지는 나머지배열 이용
        for(i=1; i<n+1; i++) {
            temp = (int) (arrSum[i]%m);
            if(temp==0) {
                result++;
            }
            remainderArr[temp]++;
        }

        //나머지 배열에서 경우의 수 계산. ex) 1번 인덱스의 값이 4면 4C2 계산 시 구간의 수 나옴
        //주의할건 0도 포함해야함. 위에서 정답케이스로 매긴 0은 (1번~해당인덱스까지합)이고
        //여기서 0은 (0값 가지는 인덱스 ~ 0값 가지는 인덱스) 구간. 다르다.
        for(i=0; i<m; i++) {
                result += (remainderArr[i] * (remainderArr[i]-1) / 2);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append('\n');

        System.out.println(sb);

    }

}


/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];
        long[] arrSum = new long[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<n+1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            arrSum[i] = arrSum[i-1] + arr[i];
        }

        int cnt = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=i; j<n+1; j++) {
                if((arrSum[j] - arrSum[i-1]) % m == 0){
                    cnt++;
                }
            }
        }

        System.out.println(sb.append(cnt));
*/