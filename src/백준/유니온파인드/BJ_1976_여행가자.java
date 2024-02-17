package 백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_여행가자 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        int[] route = new int[m];

        int i;
        for (i=1; i<n+1; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j<n+1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (i=0; i<m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        int findNum = find(route[0]); //parent 가 아니라 find 를 봐야한다. 대표노드를 반환하는 연산은 find
        for (i=1; i<m; i++) {
            if (find(route[i]) != findNum) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (i==m) { //중간에 break 했으면
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            parent[b] = a;
        }
    }
}
