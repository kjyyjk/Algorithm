package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21568_AxByC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);

        if(c%gcd != 0) {
            sb.append(-1);
        } else {
            int[] ret = excute(a, b);
            sb.append(ret[0] * (c/gcd)).append(' ');
            sb.append(ret[1] * (c/gcd)).append(' ');
        }

        System.out.println(sb);
    }

    static int[] excute(int a, int b) {
        if (b==0) {
            return new int[]{1, 0};
        }
        int[] ret = excute(b, a%b);
        int x = ret[1];
        int y = ret[0] - (ret[1]*a/b);

        return new int[]{x, y};
    }

    static int gcd(int a, int b) {
        if (b==0) {
            return a;
        }

        return gcd(b, a%b);
    }

}
