package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2828_사과담기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int ret = 0;
        int l = 1;
        int r;

        for (int i=0; i<j; i++) {
            int a = Integer.parseInt(br.readLine());
            r = l + m - 1;
            if (l > a) {
                ret += l - a;
                l = a;
            } else if (r < a) {
                ret += a - r;
                l += a - r;
            }
        }

        System.out.println(new StringBuilder().append(ret));
    }
}
