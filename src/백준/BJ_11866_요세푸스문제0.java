package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            cnt++;
            Integer number = queue.poll();
            if (cnt % k  == 0) {
                result.add(String.valueOf(number));
                continue;
            }
            queue.offer(number);
        }
        StringBuilder sb = new StringBuilder().append("<").append(String.join(", ", result)).append(">");
        System.out.println(sb);
    }
}
