package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10868_최솟값 {

    static long[] tree;
    static int leafSize;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int treeHeight = 0;

        while (Math.pow(2, treeHeight) < n) {
            treeHeight++;
        }

        leafSize = (int) Math.pow(2, treeHeight);

        tree = new long[leafSize * 2];

        int i;
        for (i=leafSize; i<leafSize + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        for (i=leafSize-1; i>0; i--) {
            if (tree[i*2] == 0) {
                tree[i] = tree[i*2 + 1];
            } else if (tree[i*2 + 1] == 0) {
                tree[i] = tree[i*2];
            } else {
                tree[i] = Math.min(tree[i*2], tree[i*2 + 1]);
            }
        }

        int a, b, s, e;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = a + leafSize - 1;
            e = b + leafSize - 1;

            printMin(s, e);
        }

        System.out.println(result);
    }

    static void printMin(int s, int e) {
        long min = Long.MAX_VALUE;

        while (s<=e) {
            if (s%2 == 1) {
                if (tree[s] != 0) {
                    min = Math.min(min, tree[s]);
                }
            }

            if (e%2 == 0) {
                if (tree[e] != 0) {
                    min = Math.min(min, tree[e]);
                }
            }

            s = (s + 1)/2;
            e = (e - 1)/2;
        }

        result.append(min).append("\n");
    }
}
