package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1213_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {

        int[] cntArr = new int['Z'-'A'+1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        for (int i=0; i<name.length(); i++) {
            cntArr[name.charAt(i)-'A']++;
        }

        int odd=0;
        int oddCnt=0;

        StringBuilder result = new StringBuilder();
        for (int i=0; i<cntArr.length; i++) {
            for (int j=0; j<cntArr[i]/2; j++) {
                result.append((char) (i+'A'));
            }

            if ((cntArr[i]%2) != 0) {
                odd = i;
                oddCnt++;
            }
        }

        if (oddCnt > 1) {
            System.out.println(new StringBuilder().append("I'm Sorry Hansoo"));
            return;
        }

        String prefix = result.toString();
        String suffix = result.reverse().toString();

        if ((name.length()%2) != 0) {
            System.out.println(prefix + ((char) (odd + 'A')) + suffix);
        } else {
            System.out.println(prefix + suffix);
        }
    }
}
