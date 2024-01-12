package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1377 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, max;
        int n = Integer.parseInt(br.readLine());

        mData[] arr = new mData[n];

        for (i = 0; i < n; i++) {
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        max = 0;
        for (i = 0; i < n; i++) {
            max = Math.max(arr[i].index - i, max);
        }
        System.out.println(sb.append(max + 1));
    }

    private static class mData implements Comparable<mData>{

        int value;
        int index;

        public mData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }
}