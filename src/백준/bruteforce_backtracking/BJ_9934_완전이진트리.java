package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9934_완전이진트리 {
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int end = (int) (Math.pow(2, k) - 1);

        arr = new int[end];
        result = new int[end + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0, end - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int temp = (int) Math.pow(2, i);
            for (int j = temp; j < temp * 2; j++) {
                sb.append(result[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void go(int a, int b, int ind) {
        int root = (a + b) / 2;
        result[ind] = arr[root];
        if (a == b) return;
        go(a, root - 1, ind * 2);
        go(root + 1, b, ind * 2 + 1);
    }
}