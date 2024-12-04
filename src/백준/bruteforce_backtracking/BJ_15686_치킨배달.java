package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 무식하게 풀이해도 시간복잡도 통과가 가능하다
 * 최대 13개의 치킨 집 중 m개를 뽑는 조합 : 약 1700개
 * 각 조합에서 최대 13개의 치킨집과 100개의 집과의 거리 계산 : 1300
 * 최종 1700 * 1300 -> 대략 3000000 가능.
 * combi 함수는 치킨집 조합을 완성해나가고 선택된 치킨집이 m개가 되면 그때 도시의 치킨 거리를 계산하여 반환한다
 * 최종적으로는 모든 조합에서의 최소 도시 치킨거리를 반환한다.
 */
public class BJ_15686_치킨배달 {
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> homes = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    homes.add(new int[]{i, j});
                }
                if (temp == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        int result = combi(-1, new ArrayList<>());
        System.out.println(new StringBuilder().append(result));
    }

    static int combi(int start, List<Integer> list) {
        if (list.size() == m) {
            int ret = 0;
            for (int[] home : homes) {
                int min = Integer.MAX_VALUE;
                for (int chickenIndex : list) {
                    int[] chicken = chickens.get(chickenIndex);
                    min = Math.min(min, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
                }
                ret += min;
            }
            return ret;
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < chickens.size(); i++) {
            list.add(i);
            min = Math.min(min, combi(i, list));
            list.remove(list.size() - 1);
        }

        return min;
    }
}
