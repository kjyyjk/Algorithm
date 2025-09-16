import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 오답 풀이
// 오답 날짜: 2025.09.13
// 복습 날짜: 2025.09.16
// 복습 회차: 2
// 문제: https://www.acmicpc.net/problem/12015
public class IncorrectAnswerNote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int left = 0;
                int right = list.size() - 1;

                int replaceInd = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= num) {
                        replaceInd = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(replaceInd, num);
            }
        }
        System.out.println(list.size());
    }
}
