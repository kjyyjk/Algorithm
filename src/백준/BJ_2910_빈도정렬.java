package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2910_빈도정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Long> input = new Vector<>();
        List<Long> ret = new Vector<>();
        Map<Long, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            long temp = Long.parseLong(st.nextToken());
            input.add(temp);
            ret.add(temp);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp)+1);
            } else {
                map.put(temp, 1);
            }
        }

        Collections.sort(ret, (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return input.indexOf(a) - input.indexOf(b);
            } else {
                return map.get(b) - map.get(a);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(ret.get(i)).append(' ');
        }

        System.out.println(sb);
    }
}
