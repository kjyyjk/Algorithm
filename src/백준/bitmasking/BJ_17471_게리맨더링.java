package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {
    static int n;
    static List<Integer>[] arr;
    static int[] person;
    static List<Integer> dfsList;
    static boolean[] visited;
    static int total;
    static int INF = 10000;
    static int ret = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 4];
        person = new int[n + 4];

        total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            person[i] = Integer.parseInt(st.nextToken());
            total += person[i];
        }

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < (1 << n) - 1; i++) {
            if (!check(i)) continue;
            if (!check(~i)) continue;
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp += person[j + 1];
                }
            }
            ret = Math.min(ret, Math.abs(total - 2 * temp));
        }

        if (ret == INF) {
            System.out.println(new StringBuilder().append(-1));
        } else {
            System.out.println(new StringBuilder().append(ret));
        }
    }

    static boolean check(int num) {
        dfsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((num & (1 << i)) != 0) {
                dfsList.add(i + 1);
            }
        }

        visited = new boolean[n + 4];
        visited[dfsList.get(0)] = true;
        dfs(dfsList.get(0));
        for (int i : dfsList) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int here) {
        for (int there : arr[here]) {
            if (!dfsList.contains(there)) continue;
            if (visited[there]) continue;
            visited[there] = true;
            dfs(there);
        }
    }
}
