package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력으로 받은 문자열을 정규 표현식을 활용해 pi 또는 ka 또는 chu로 split한다.
 * 만약 pi, ka, chu 외에 다른 문자가 없다면 split 결과는 길이 0이 된다.
 */
public class BJ_14405_피카츄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        if (s.split("pi|ka|chu").length == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        System.out.println(sb);
    }
}
