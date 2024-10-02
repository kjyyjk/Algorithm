package 백준;

import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BJ_2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> result = new Vector<>();
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            boolean is_prev_digit = false;
            String prev = "";

            for (int j=0; j<s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    is_prev_digit = true;

                    if (!prev.equals("0")) {
                        prev = prev + s.charAt(j);
                    } else {
                        prev = "" + s.charAt(j);
                    }
                } else {
                    if (is_prev_digit) {
                        result.add(prev);
                    }
                    is_prev_digit = false;
                    prev = "";
                }
            }

            if (is_prev_digit) {
                result.add(prev);
            }
        }

        Collections.sort(result, (a, b) -> {
            if (a.length() == b.length() && !a.equals(b)) {
                return a.compareTo(b);
            }

            return a.length() - b.length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<result.size(); i++) {
            sb.append(result.get(i)).append('\n');
        }

        System.out.println(sb);
    }
}
