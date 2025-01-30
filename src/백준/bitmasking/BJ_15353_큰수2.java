package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수의 범위가 int나 long으로 처리되지 못하는 크기이기 때문에 문자열로 입력 받아 덧셈을 한다.
 * 올림을 고려하기 위해 끝 자리부터 한자리씩 덧셈을 수행한다.
 *
 * 매 덧셈의 결과인 sum을 10으로 나눈 나머지는 결과에 추가한다.
 * 매 자리 덧셈의 결과인 sum을 10으로 나눈 몫을 다음 자리 덧셈에서 더해준다.(올림)
 *
 * 어느 한 숫자라도 범위를 벗어나면 반복을 종료한다.
 * 만약 끝까지 덧셈을 하지 않은 수가 존재하면 올림을 고려하여 남은 수를 더해준다.
 *
 * 두 숫자 모두 끝나고 나면 마지막으로 올림이 있는 지 확인하고 올림이 있으면 추가한다.
 * 마지막으로, 모든 과정이 끝자리서부터 진행되었기에 결과를 뒤집어 출력한다.
 */
public class BJ_15353_큰수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;
        while (i >= 0 && j >= 0) {
            sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + sum;
            sb.append(sum % 10);
            sum /= 10;
            i--;
            j--;
        }

        if (i > j) {
            while (i >= 0) {
                sum = (num1.charAt(i) - '0') + sum;
                sb.append(sum % 10);
                sum /= 10;
                i--;
            }
        } else {
            while (j >= 0) {
                sum = (num2.charAt(j) - '0') + sum;
                sb.append(sum % 10);
                sum /= 10;
                j--;
            }
        }
        if (sum == 1) {
            sb.append(sum);
        }
        System.out.println(sb.reverse());
    }
}
