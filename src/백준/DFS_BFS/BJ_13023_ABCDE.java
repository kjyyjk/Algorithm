package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, a, b;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        visited = new boolean[n];

        for(i=0; i<n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        result = 0;
        for(i=0; i<n; i++) {
            dfs(i,1);
            if (result == 1) {
                break;
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

    static void dfs(int k, int cnt) {
        visited[k] = true;

        if(result == 1 || cnt == 5) {
            result = 1;
            return;
        }

        for (int i : arr[k]) {
            if(visited[i] == false) {
                dfs(i, cnt+1);
            }

        }

        visited[k] = false;
    }

}
