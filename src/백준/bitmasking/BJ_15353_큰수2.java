package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 정수의 범위가 int나 long으로 처리되지 못하는 크기이기 때문에 문자열로 입력 받아 덧셈을 해야한다.
 * 하지만 자바에서는 BigInteger로 무한에 가까운 수를 다룰 수 있다.
 */
public class BJ_15353_큰수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger ret = new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken()));
        System.out.println(new StringBuilder().append(ret));
    }
}
