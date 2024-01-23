package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {

    static int[] dx = {0, 0, -1, 1}; //x인덱스 이동(상하좌우)
    static int[] dy = {-1, 1, 0, 0}; //y인덱스 이동(상하좌우)
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                arr[i][j] = input[j] - '0';
            }
        }

        bfs(0,0);

        System.out.println(new StringBuilder().append(arr[n-1][m-1]));
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        arr[i][j] = 1; //시작 노드 depth 1

        while(!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            for(int k=0; k<4; k++) { //noNode 기준 상하좌우 노드 탐색
                int nextX = nowNode[0] + dx[k];
                int nextY = nowNode[1] + dy[k];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) { //범위 체크
                    if(arr[nextX][nextY]!=0 && visited[nextX][nextY] == false) { //0이 아니고, 방문x
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = arr[nowNode[0]][nowNode[1]] + 1; //깊이는 현재깊이 + 1
                    }
                }
            }
        }

    }
}
