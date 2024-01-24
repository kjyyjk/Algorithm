package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11720_숫자합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String sNum = br.readLine();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for(int i = 0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sb.append(sum));
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for(int i = 0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);*/
    }
}
