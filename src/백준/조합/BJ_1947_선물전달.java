package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1947_선물전달 {

    static long t = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] d = new long[n+2]; //n=1 또는 2일 경우 아래 두줄에서 인덱스 에러. 따라서 n+2를 해줌
        d[1] = 0;
        d[2] = 1;

        for (int i=3; i<n+1; i++) {
            d[i] = ((i-1) * (d[i-2] % t + d[i-1] % t)) % t; //d[i] = (n-1) * (d[n-2] + d[n-1])
        }

        System.out.println(new StringBuilder().append(d[n]));
    }
}
