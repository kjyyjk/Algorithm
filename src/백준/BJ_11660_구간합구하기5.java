package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int i, j, x1, y1, x2, y2, result;
        int[][] arr = new int[n+1][n+1];
        int[][] arrSum = new int[n+1][n+1];

        //원본 배열과 구간 합 배열 값 채우기
        for(i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(j=1; j<n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arrSum[i][j] = arrSum[i-1][j] + arrSum[i][j-1] + arr[i][j] - arrSum[i-1][j-1];
            }
        }

        //각 정답 구하기
        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            result = arrSum[x2][y2] - arrSum[x2][y1-1] - arrSum[x1-1][y2] + arrSum[x1-1][y1-1];

            sb.append(result).append('\n');
        }

        System.out.println(sb);
        br.close();

    }
}
