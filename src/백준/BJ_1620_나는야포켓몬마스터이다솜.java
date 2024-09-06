package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n+4
                ];
        Map<String, Integer> map = new HashMap<>();

        for (int i=1; i<n+1; i++) {
            String name = br.readLine();
            arr[i] = name;
            map.put(name, i);
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<m; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                result.append(arr[Integer.parseInt(input)]).append('\n');
            } else {
                result.append(map.get(input)).append('\n');
            }
        }

        System.out.println(result);
    }
}
