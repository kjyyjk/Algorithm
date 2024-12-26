package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제에서는 완전 이진트리에 inorder 순회를 한다.
 * 따라서 주어진 구간에서 가운데 위치한 노드가 해당 구간의 루트가 될 것이다.
 * 가운데, 즉 서브 루트를 기준으로 왼쪽 구간은 왼쪽 자식 트리, 오른쪽 구간은 오른쪽 자식 트리.
 *
 * 재귀함수 go()를 통해 전체 구간을 시작으로 탐색 시작.
 */
public class BJ_9934_완전이진트리 {
    static int[] arr;
    static List<Integer>[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int end = (int) (Math.pow(2, k) - 1);

        arr = new int[end];
        result = new List[k + 1];
        for (int i = 1; i < k + 1; i++) {
            result[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0, end - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < result[i].size(); j++) {
                sb.append(result[i].get(j)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void go(int s, int e, int level) {
        if (s > e) return;
        if (s == e) {
            result[level].add(arr[s]);
            return;
        }
        int root = (s + e) / 2;
        result[level].add(arr[root]);
        go(s, root - 1, level + 1);
        go(root + 1, e, level + 1);
    }
}
