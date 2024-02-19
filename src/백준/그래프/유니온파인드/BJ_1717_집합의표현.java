package 백준.그래프.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717_집합의표현 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i=1; i<n+1; i++) {
            parent[i] = i;
        }

        int k, a, b;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (k==0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            int temp = find(parent[a]); //find 연산의 경로 압축
            parent[a] = temp;
            return temp;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            parent[b] = a;
        }
    }
}
