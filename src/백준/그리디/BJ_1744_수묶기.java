package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1744_수묶기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Queue<Integer> queueP; // 양수를 담을 우선순위큐 (내림차순)
        Queue<Integer> queueM; // 음수를 담을 우선순이큐 (오름차순)

        queueP = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        queueM = new PriorityQueue<>();

        int cnt0 = 0; // 0 개수
        int cnt1 = 0; // 1 개수

        for (int i=0; i<n; i++) {
            int inputNum = Integer.parseInt(br.readLine());

            if (inputNum > 1) {
                queueP.add(inputNum);
            } else if (inputNum < 0) {
                queueM.add(inputNum);
            } else if (inputNum == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
        }

        int result = 0;

        while (queueP.size() > 1) {
            result += queueP.poll() * queueP.poll();
        }
        if (!queueP.isEmpty()) {
            result += queueP.poll();
        }

        while (queueM.size() > 1) {
            result += queueM.poll() * queueM.poll();
        }
        if (!queueM.isEmpty() && cnt0 == 0) {
            result += queueM.poll();
        }

        result += cnt1;

        System.out.println(new StringBuilder().append(result));
    }

}
