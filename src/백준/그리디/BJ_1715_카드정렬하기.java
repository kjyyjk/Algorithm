package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> priorityQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0; i<n; i++) {
            priorityQ.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        while(priorityQ.size() != 1) {
            int temp = priorityQ.poll() + priorityQ.poll();
            result += temp;
            priorityQ.add(temp);
        }

        System.out.println(new StringBuilder().append(result));
    }

}
