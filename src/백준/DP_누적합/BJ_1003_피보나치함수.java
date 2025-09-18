package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.StringBuilder;

public class BJ_1003_피보나치함수 {

    private static Integer[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new Integer[41][2];
        arr[0] = new Integer[]{1, 0};
        arr[1] = new Integer[]{0, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            Integer[] result = pib(num);
            sb.append(result[0]).append(' ').append(result[1]).append('\n');
        }

        System.out.println(sb);
    }

    static Integer[] pib(int num) {
        if (num == 0 || num == 1) {
            return arr[num];
        }

        Integer[] prev1 = (arr[num - 1][0] == null) ? pib(num - 1) : arr[num - 1];
        Integer[] prev2 = (arr[num - 2][0] == null) ? pib(num - 2) : arr[num - 2];

        Integer[] newArr = new Integer[]{prev1[0] + prev2[0], prev1[1] + prev2[1]};
        arr[num] = newArr;

        return newArr;
    }
}
