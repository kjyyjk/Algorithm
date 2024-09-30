package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            boolean flag = false;
            boolean is_include_v = false;
            char prev = 'a';
            int vcnt = 0; //연속 모음 수
            int lcnt = 0; //연속 자음 수

            for (int i=0; i<input.length(); i++) {
                char c = input.charAt(i);

                if (isVowel(c)) {
                    vcnt++;
                    lcnt = 0;
                    is_include_v = true;
                } else {
                    lcnt++;
                    vcnt = 0;
                }

                if (lcnt == 3 || vcnt == 3) flag = true;
                if (i>0 && prev == c && prev != 'e' && prev != 'o') flag = true;

                prev = c;
            }

            if (!is_include_v) flag = true;

            if (flag) {
                sb.append("<" + input + "> is not acceptable.").append('\n');
            } else {
                sb.append("<" + input + "> is acceptable.").append('\n');
            }
        }

        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
