package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2042_구간합구하기 {

    static int leafSize; //리프 개수
    static long[] tree;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        leafSize = 1;

        while(leafSize < n) {
            leafSize *= 2;
        }

        tree = new long[leafSize * 2];

        int i;
        for (i=leafSize; i<leafSize + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        for (i=leafSize-1; i>0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        int a, b;
        long c;
        for (i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a==1) {
                change(b, c);
            } else {
                printHap(b, c);
            }
        }

        System.out.println(result);
    }

    static void change(int b, long c) {
        int treeInd = b + leafSize - 1;
        long diff = c - tree[treeInd]; //변경 후 발생 차이

        tree[treeInd] = c;

        while (treeInd > 1) {
            treeInd /= 2;

            tree[treeInd] += diff;
        }
    }

    static void printHap(int b, long c) {
        int s = b + leafSize - 1;
        int e = (int)c + leafSize - 1;

        long hap = 0;
        while (s<=e) {
            if (s%2 == 1) {
                hap += tree[s];
            }

            if (e%2 == 0) {
                hap += tree[e];
            }

            s = (s+1)/2;
            e = (e-1)/2;
        }

        result.append(hap).append('\n');
    }

}
