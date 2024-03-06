package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1068_트리 {

    static int rootNode, deleteNode, result;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        tree = new ArrayList[n];

        int i;
        for (i=0; i<n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int parentNode;
        for (i=0; i<n; i++) {
            parentNode = Integer.parseInt(st.nextToken());

            if (parentNode == -1) {
                rootNode = i;
            } else {
                tree[i].add(parentNode);
                tree[parentNode].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == rootNode) {
            System.out.println(new StringBuilder().append(0));
        } else {
            result = 0;
            dfs(rootNode);
            System.out.println(new StringBuilder().append(result));
        }
    }

    static void dfs(int nowNode) {
        visited[nowNode] = true;
        boolean leaf = true;

        for (int nextNode : tree[nowNode]) {
            if (visited[nextNode] == false && nextNode != deleteNode) {
                leaf = false;
                dfs(nextNode);
            }
        }

        if (leaf) {
            result++;
        }
    }
}