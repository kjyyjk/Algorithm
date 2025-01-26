package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 입력 배열을 substring으로 파싱하고 ,를 기준으로 split한다.
 * 이때 숫자가 없을 경우에도 공백 문자가 추가될 수 있으므로 split한 문자가 blank인지 체크한다.
 *
 * 두 가지 연산이 필요하다.
 * 뒤집는 연산, 첫번째 원소를 제거하는 연산.
 *
 * 실제로 뒤집지 않고 뒤집힌 상태 reverse를 보관한다.
 * reverse가 false일 때 D명령을 수행하는 것은 배열의 첫 원소를 제거하는 것과 같다.
 * reverse가 true일 때 D명령을 수행하는 것은 배열의 마지막 원소를 제거하는 것과 같다.
 */
public class BJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> list;
        for (int k = 0; k < t; k++) {
            boolean reverse = false;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            list = new ArrayList<>();
            for (String num : arr.substring(1, arr.length() - 1).split(",")) {
                if (!num.isBlank()) {
                    list.add(num);
                }
            }
            boolean error = false;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (c == 'R') {
                    reverse = !reverse;
                } else {
                    if (list.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reverse) {
                        list.remove(list.size() - 1);
                    } else {
                        list.remove(0);
                    }
                }
            }
            if (error) {
                sb.append("error").append('\n');
                continue;
            }
            sb.append("[");
            if (reverse) {
                List<String> reverseList = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    reverseList.add(list.get(i));
                }
                sb.append(String.join(",", reverseList));
            } else {
                sb.append(String.join(",", list));
            }
            sb.append("]").append('\n');
        }
        System.out.println(sb);
    }
}
