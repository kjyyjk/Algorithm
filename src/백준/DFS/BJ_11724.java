package 백준.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11724 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, u, v;
        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(i=1; i<n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u); //양방향 에지니 양쪽에 추가하는 걸 잊지말자
        }

        for(i=1; i<n+1; i++) {
            if(visited[i] == false) {
                result++;
                dfs(i);
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i : arr[node]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }
}
