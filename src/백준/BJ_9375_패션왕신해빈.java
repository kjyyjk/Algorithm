package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_9375_패션왕신해빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Map<String, Integer> map;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {

            long result = 1;
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            for (int j=0; j<n; j++) {
                String s = br.readLine().split(" ")[1];
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s)+1);
                }
            }

            for (String key : map.keySet()) {
                result *= map.get(key)+1;
            }

            result--;

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
