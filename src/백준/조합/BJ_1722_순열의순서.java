package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1722_순열의순서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[21]; //방문 배열 초기화

        long[] f = new long[21];
        f[0] = 1;
        int i, j;
        for (i=1; i<n+1; i++) { //경우의 수 초기화
            f[i] = f[i-1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        if (Integer.parseInt(st.nextToken()) == 1) { //Q1
            long k = Long.parseLong(st.nextToken());

            long cnt;
            for (i=1; i<n+1; i++) {

                cnt = 1;
                for (j=1; j<n+1; j++) { //방문 안한 수 중 조건을 만족하는 cnt번째 수를 정답으로 추가
                    if (visited[j] == true) {
                        continue;
                    }

                    if (k <= f[n-i] * cnt) {
                        k -= f[n-i] * (cnt-1);
                        sb.append(j).append(' ');
                        visited[j] = true;
                        break;
                    }

                    cnt ++;
                }
            }

            System.out.println(sb);

        } else { //Q2
            long k = 1;
            long num, temp;
            for (i=1; i<n+1; i++) {
                num = Integer.parseInt(st.nextToken());

                temp = 1;
                for (j=1; j<n+1; j++) { //현재 자리의 수가 방문 안한 수 중 몇번째인지 -> temp

                    if (visited[j] == true) {
                        continue;
                    }

                    if (j==num) {
                        visited[j] = true;
                        break;
                    } else {
                        temp++;
                    }
                }

                k += f[n-i] * (temp-1); //알맞게 k 증가
            }

            System.out.println(sb.append(k));
        }
    }
}
