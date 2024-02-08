package 백준.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1033_칵테일 {

    static boolean[] visited;
    static ArrayList<Node>[] arr;
    static long gcdResult;
    static long[] resultArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n];
        visited = new boolean[n];
        resultArr = new long[n];

        for (int i=0; i<n; i++) {
            arr[i] = new ArrayList<Node>();
        }

        int a, b, i;
        long p, q;
        long lcm = 1;

        StringTokenizer st;
        for (i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));

            lcm *= (p * q)/gcd(p, q); //해당하는 모든 비율의 최소공배수 구하기
        }

        resultArr[0] = lcm; // 임의의 노드에 최소공배수 저장하고

        dfs(0); // 임의의 노드 기준으로 모든 노드 값 구하기

        gcdResult = resultArr[0]; // 모든 값의 최대 공약수
        for(i=1; i<n; i++) {
            gcdResult = gcd(gcdResult, resultArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(i=0; i<n; i++) {
            sb.append(resultArr[i]/gcdResult).append(' ');
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) { //유클리드 호제법
        if (b==0) {
            return a;
        }

        return gcd(b, a%b);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (Node nextNode : arr[node]) {
            if (visited[nextNode.b] == false) {
                resultArr[nextNode.b] = resultArr[node] * nextNode.q / nextNode.p;
                dfs(nextNode.b);
            }
        }
    }

    static class Node {
        int b;
        long p;
        long q;

        public Node(int b, long p, long q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

    }

}
