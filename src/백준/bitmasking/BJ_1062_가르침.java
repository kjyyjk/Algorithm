package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {
    static int n;
    static int[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (k < 5) {
            System.out.println(sb.append(0));
            return;
        }
        if (k == 26) {
            System.out.println(sb.append(n));
            return;
        }

        words = new int[n + 4];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (char c : br.readLine().toCharArray()) {
                temp = temp | (1 << c - 'a');
            }
            words[i] = temp;
        }

        int ret = go(0, k, 0);
        System.out.println(sb.append(ret));
    }

    static int go(int idx, int cnt, int num) {
        if (cnt < 0) { // 배울 수 있는 글자를 초과한 경우
            return 0;
        }
        if (idx == 26) { // 0('a') ~ 25('z')까지 모든 글자에 대한 경우의 수를 세어 조합을 완성했으면
            return solve(num);
        }
        int ret = 0;
        ret = Math.max(ret, go(idx + 1, cnt - 1, num | (1 << idx)));
        if (idx != 'a' - 'a' && idx != 'n' - 'a' && idx != 't' - 'a' && idx != 'i' - 'a' && idx != 'c' - 'a') {
            ret = Math.max(ret, go(idx + 1, cnt, num));
        }
        return ret;
    }

    private static int solve(int num) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int word = words[i];
            if ((num & word) == word) { // 배운 글자와 단어를 and연산 했을 때 단어와 같은 결과가 나오면 배울 수 있는 단어이다.
                cnt++;
            }
        }
        return cnt;
    }
}
