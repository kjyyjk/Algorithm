package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] a = new int[h+4][w+4];

        int t;
        for (int i=0; i<h; i++) {
            t = -1;
            String[] s = br.readLine().split("");

            for (int j=0; j<w; j++) {
                if (s[j].equals("c")) {
                    t = 0;
                }

                a[i][j] = t;
                if (t != -1) t++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                sb.append(a[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
