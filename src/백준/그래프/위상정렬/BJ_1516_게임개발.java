package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1516_게임개발 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] inDegree = new int[n+1];
        int[] time = new int[n+1]; //소요시간
        int[] result = new int[n+1]; //최소완료시간

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int k;
        for (int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            time[i] = Integer.parseInt(st.nextToken());

            while(true) {
                k = Integer.parseInt(st.nextToken());

                if (k==-1) {
                    break;
                } else {
                    arr[k].add(i);
                    inDegree[i]++;
                }
            }
        }

        //위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<n+1; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int nowNode;
        while (!queue.isEmpty()) {
            nowNode = queue.poll();
            result[nowNode] += time[nowNode]; //최소완료시간 = 선행작업의 최대완료시간 + 소요시간

            for (int nextNode : arr[nowNode]) {
                result[nextNode] = Math.max(result[nowNode], result[nextNode]); //선행작업완료시간 최대로 유지

                if (--inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n+1; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }

}
