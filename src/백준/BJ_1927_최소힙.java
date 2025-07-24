package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 최소 힙의 시간 복잡도 -> n * 트리의 높이 -> n * logn -> O(nlogn)
 * 삽입 시 가장 마지막 노드에 삽입 후 부모 노드와 비교. 더 작으면 교체.
 * 삭제 시 루트 노드 제거. 가장 마지막 노드 루트에 위치 후 자식과 비교. 더 크면 교체.
 */
public class BJ_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Long> priorityQueue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num != 0) {
                priorityQueue.offer(num);
                continue;
            }
            Long min = priorityQueue.poll();
            if (min == null) {
                min = 0L;
            }
            sb.append(min).append('\n');
        }
        System.out.println(sb);
    }
}
