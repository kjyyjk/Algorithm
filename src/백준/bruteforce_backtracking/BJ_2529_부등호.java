package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 복잡도는 O(10!) == 3,600,000이므로 완전탐색이 가능하다
 * 
 * go 안에서는 다음 로직을 수행한다.
 * 다음 올 수가 사용된 적 없는 지 체크한다.
 * 다음 올 수가 부등호 조건을 만족하는 지 체크한다.
 * 이후 숫자를 추가하고 재귀호출한다.
 * 만약 정해진 수만큼의 숫자가 추가되었다면. 최대와 최소를 각각 갱신하고 return 한다.
 * 이렇게 모든 경우를 다 탐색한다.
 *
 * 맨 앞 0이 유지되어야하고, 범위가 크기 때문에 숫자를 문자열로 관리한다.
 * 따라서 대소 비교시 문자열 비교(compareTo)를 사용한다
 * 
 * num의 idx를 따로 유지하지 않고, 길이로 판단한다.
 */
public class BJ_2529_부등호 {
    static int k;
    static String max = "0";
    static String min = "99999999999";
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        arr = new String[k];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        go("");

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    static void go(String num) {
        if (num.length() == k + 1) { // 정해진 수를 채웠으므로 대소 비교 후 max, min 갱신
            if (max.compareTo(num) < 0) {
                max = num;
            }
            if (min.compareTo(num) > 0) {
                min = num;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (num.length() != 0 && arr[num.length() - 1].equals(">")) { // 맨 앞자리가 아닐 때 부등호 조건 체크
                if (Integer.parseInt(num) % 10 <= i) continue;
            }
            if (num.length() != 0 && arr[num.length() - 1].equals("<")){
                if (Integer.parseInt(num) % 10 >= i) continue;
            }
            visited[i] = true;
            go(num + i);
            visited[i] = false;
        }
    }
}
