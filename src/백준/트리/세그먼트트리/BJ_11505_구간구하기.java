package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * (a * b) % c == ((a % c) * (b % c)) % c
 */
public class BJ_11505_구간구하기 {

    static long[] tree;
    static int leafSize;
    static StringBuilder result = new StringBuilder();
    static final long modNum = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int treeHeight = 0;

        while (Math.pow(2, treeHeight) < n) {
            treeHeight++;
        }

        leafSize = (int) Math.pow(2, treeHeight);
        tree = new long[leafSize * 2];

        int i;
        for (i=0; i<leafSize*2; i++) {
            tree[i] = 1;
        }

        for (i=leafSize; i<leafSize+n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (i=leafSize-1; i>0; i--) {
            tree[i] = ((tree[i*2] % modNum) * (tree[i*2 + 1] % modNum)) % modNum;
        }

        int a, b;
        long c;
        for (i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a==1) {
                change(b, c);
            }

            if (a==2) {
                printResult(b, c);
            }
        }

        System.out.println(result);
    }

    static void change(int b, long c) {
        b = b + leafSize - 1;

        tree[b] = c;

        while (b > 1) {
            b /= 2;
            
            tree[b] = ((tree[b*2] % modNum) * (tree[b*2 + 1] % modNum)) % modNum;
        }
    }

    static void printResult(int b, long c) {

        int s = b + leafSize - 1;
        int e = (int)c + leafSize - 1;

        int temp = 1;

        while (s<=e) {
            if (s%2 == 1) {
                temp = (int)(((tree[s] % modNum) * (temp % modNum)) % modNum);
            }

            if (e%2 == 0) {
                temp = (int)(((tree[e] % modNum) * (temp % modNum)) % modNum);
            }

            s = (s+1)/2;
            e = (e-1)/2;
        }

        result.append(temp).append('\n');
    }

}
