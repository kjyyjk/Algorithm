package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든 경우의 수를 고려하여 최대 합을 구해야한다.
 *
 * 각 자리를 0 또는 1로 나타낸다.
 * 이때 0은 가로, 1은 세로를 의미한다.
 * ex)
 * 0 0 0
 * 1 0 0
 * 1 0 1 은 가로 000, 가로 00, 세로 11, 가로 0, 세로 1 총 5개의 종이 조각으로 이루어진 것이다.
 *
 * 이렇게 0과 1로 구성된 모든 경우의 수를 고려해야한다.
 * n * m은 최대 14이므로 비트마스킹으로 이 경우의 수를 표현할 수 있다.
 * ex)
 * 0 0 0
 * 1 0 0
 * 1 0 1은 000100101로 나타내고 (1,1)은 1 * 3 + 1번째로 변환할 수 있다.
 *
 * 비트마스킹을 활용해 각 경우 s에서 가로와 세로 종이 조각의 합을 구하고 최대로 갱신한다.
 *
 * 가로 합을 구하는 로직을 설명하자면
 * 행 별로 가로를 의미하는 0이 나오는 동안은 숫자를 만들어가다가 세로를 의미하는 1이 나오면 여태 만들어낸 숫자를 sum에 더한다.
 * 그리고 다시 숫자를 만들어가며 해당 행의 끝까지 도달하고 도달 시점에 만들어낸 숫자를 sum에 더한다.
 * (세로 합은 열을 기준으로 진행하면 된다.)
 */
public class BJ_14391_종이조각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 4][m + 4];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int ret = 0;
        for (int s = 0; s < (1 << (n * m)); s++) { // 하나의 경우의 수
            int sum = 0;
            for (int i = 0; i < n; i++) { // 가로 종이 조각의 합
                int temp = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {
                        sum += temp;
                        temp = 0;
                    } else {
                        temp = temp * 10 + map[i][j];
                    }
                }
                sum += temp; // 마지막에 털어야한다
            }
            for (int j = 0; j < m; j++) { // 세로 종이 조각의 합
                int temp = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {
                        sum += temp;
                        temp = 0;
                    } else {
                        temp = temp * 10 + map[i][j];
                    }
                }
                sum += temp; // 마지막에 털어야한다
            }
            ret = Math.max(ret, sum); // 갱신
        }
        System.out.println(new StringBuilder().append(ret));
    }
}
