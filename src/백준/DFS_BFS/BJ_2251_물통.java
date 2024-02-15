package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2251_물통 {

    static int[] sender = {0, 0, 1, 1, 2, 2}; //물을 옮길 수 있는 6가지 경우의 수
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static int[] maxArr = new int[3]; //초기 입력 받은 물통 크기
    static int[] nowArr = new int[3]; //물통에 현재 들어있는 물의 양
    static boolean[][] visited = new boolean[201][201]; //a,b 물통의 현재 물 양을 기준으로 방문 여부
    static boolean[] resultArr = new boolean[201]; //a 물통이 비었을 때 c 물통의 물 양 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        maxArr[0] = Integer.parseInt(st.nextToken());
        maxArr[1] = Integer.parseInt(st.nextToken());
        maxArr[2] = Integer.parseInt(st.nextToken());

        bfs(new Node(0, 0)); //초기 a=0, b=0에서 시작

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< resultArr.length; i++) {
            if (resultArr[i] == true) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    static void bfs(Node n) {
        Queue<Node> queue = new LinkedList<>();
        visited[n.a][n.b] = true;
        queue.add(n);

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            if (nowNode.a == 0) { //a 물통이 비었을 때 c 물통의 양 체크
                resultArr[maxArr[2] - nowNode.a - nowNode.b] = true;
            }

            int i, s, r;
            for (i=0; i<6; i++) {
                s = sender[i];
                r = receiver[i];

                nowArr[0] = nowNode.a;
                nowArr[1] = nowNode.b;
                nowArr[2] = maxArr[2] - nowNode.a - nowNode.b; //c 물통의 양은 a,b를 통해 추정

                if (nowArr[s] + nowArr[r] > maxArr[r]) { //s->r 에서 r이 넘치는 경우
                    nowArr[s] = nowArr[s] + nowArr[r] - maxArr[r]; //s 물통에 남는 양
                    nowArr[r] = maxArr[r]; //r은 꽉참
                } else { //s->r 에서 r이 넘치지 않는 경우
                    nowArr[r] = nowArr[r] + nowArr[s];
                    nowArr[s] = 0; //s 물통은 비게 된다
                }

                if (visited[nowArr[0]][nowArr[1]] == false) { //물 이동 후 a,b의 양이 중복되지 않는다면
                    queue.add(new Node(nowArr[0], nowArr[1]));
                    visited[nowArr[0]][nowArr[1]] = true;
                }
            }
        }
    }

    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
