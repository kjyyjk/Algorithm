package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 26개의 각 글자를 배울지, 안배울지 -> O(2^26)의 시간 복잡도
 *
 * 배운 글자 -> 비트마스킹으로 보관
 * 단어 -> 비트마스킹으로 보관
 *
 * 배운 글자와 단어를 and연산한 결과가 단어이면 해당 단어는 배울 수 있는 것이다.
 * 비트 연산으로 계산하여 훨씬 빠른 속도.
 * ex)
 * 11011
 * 10011
 * ------
 * 10011 (가능)
 *
 * 11011
 * 11111
 * ------
 * 11011 != 11111 (불가능)
 *
 * go()는 idx, cnt, num을 인자로 받는다.
 * idx는 a~z까지의 인덱스를 의미하며 배울지 안배울지를 고려하는 글자를 의미한다.
 * cnt는 현재까지 남은 배울 수 있는 글자를 의미한다. 만약 cnt가 음수면 배울 수 있는 글자를 초과했다는 것이므로 조합에 추가하지 않는다.
 * num은 현재까지 배운 글자를 비트마스킹으로 보관하는 수이다.
 * 팁 ) a,n,t,i,c는 기본으로 배워야한다. 따라서 a,n,t,i,c를 배우지 않는 조합은 만들지 않는다.
 *
 */
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
