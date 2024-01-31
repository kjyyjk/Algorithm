package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int firstNum = calculate(st.nextToken());

        int sum = 0;
        while(st.hasMoreTokens()) {
            sum += calculate(st.nextToken());
        }

        int result = firstNum - sum;

        System.out.println(new StringBuilder().append(result));

    }

    private static int calculate(String s) {
        int tempSum = 0;
        StringTokenizer st = new StringTokenizer(s, "+");

        while(st.hasMoreTokens()) {
            tempSum += Integer.parseInt(st.nextToken());
        }

        return tempSum;
    }

}
