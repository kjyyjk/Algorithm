package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> cards = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        cards.sort(null);

        int m = Integer.parseInt(br.readLine());

        List<String> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            boolean exists = binarySearch(cards, num);
            if (exists) {
                result.add("1");
            } else {
                result.add("0");
            }
        }
        System.out.println(String.join(" ", result));
    }

    static boolean binarySearch(List<Integer> cards, int num) {
        int start = 0;
        int end = cards.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (cards.get(mid) == num) {
                return true;
            }
            if (cards.get(mid) > num) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return false;
    }
}
