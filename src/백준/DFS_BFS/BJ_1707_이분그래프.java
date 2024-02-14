package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1707_이분그래프 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] check;
    static boolean dfsResult;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int i, j, v, e, a, b;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            arr = new ArrayList[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];

            for (j=1; j<v+1; j++) {
                arr[j] = new ArrayList<>();
            }

            for (j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                arr[a].add(b);
                arr[b].add(a);
            }

            dfsResult = true;
            for (j=1; j<v+1; j++) { //연결 그래프가 아닐 수 있으므로 모든 연결요소 고려
                if (visited[j] == false) {
                    dfs(j, 1);
                }

                if(dfsResult==false) { //이미 정답이 아닐 경우 더이상 진행 x
                    break;
                }
            }

            if (dfsResult == true) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int n, int x) { //x는 n의 집합과 다른 인접노드의 집합 번호
        visited[n] = true;

        for (int nextNode : arr[n]) {
            if (dfsResult==false) { //이미 이분 그래프가 아닌게 밝혀진 경우
                break;
            }

            if (visited[nextNode] == false) {
                check[nextNode] = x; //방문 안한 노드의 집합은 현재 노드의 집합과 다른 x집합
                dfs(nextNode, check[n]); //인접 노드의 인접 노드는 현재 노드와 같은 집합이어야 함
            } else { //이미 방문한 인접 노드일 경우
                if (check[nextNode] == check[n]) { //현재 노드와 집합이 같으면 이분그래프 x
                    dfsResult = false;
                    break;
                }
            }
        }
    }
}
