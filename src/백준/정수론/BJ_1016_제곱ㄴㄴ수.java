package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1016_제곱ㄴㄴ수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[(int)(max - min + 1)]; // 제곱ㄴㄴ수 체크 배열

        long startInd, pow;

        for (long i=2; i*i <= max; i++) {
            pow = i*i; // 제곱수
            if (min%pow == 0) { //pow*j(제곱수의 배수)이 min보다 커야하므로, min을 넘기는 처음 j 값을 구한다
                startInd = min/pow;
            } else {
                startInd = min/pow + 1; //나머지가 있으면 곱해도 min을 넘기지 못하기 때문에 +1
            }

            for(long j=startInd; pow*j <= max; j++) { //pow*j, 즉 min 보다 큰 제곱수의 배수 제거
                arr[(int)(pow*j-min)] = true; //pow*j 에서 min만큼 빼주어 체크 배열 인덱스에 맞춤
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == false) { //남은 제곱ㄴㄴ수 개수 체크
                cnt++;
            }
        }

        System.out.println(new StringBuilder().append(cnt));

    }

}
