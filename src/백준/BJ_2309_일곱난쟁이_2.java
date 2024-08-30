package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이_2 { //재귀함수로 순열을 구현하여 풀이
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makePermutation(9, 7, 0);
    }

    static void makePermutation(int n, int r, int depth) {
        if (r == depth) {
            solve(); //해당 순열에서 앞 7개의 합이 100인지 확인
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(i, depth);
            makePermutation(n, r, depth+1); //재귀호출
            swap(i, depth);
        }
    }

    private static void solve() {
        int total = 0;
        for (int i=0; i<7; i++) {
            total += arr[i];
        }

        if (total == 100) { // 앞 7개의 합이 100이면
            Arrays.sort(arr, 0, 7); //앞 7개만 정렬 후
            for (int i=0; i<7; i++) {
                System.out.println(arr[i]); //출력
            }
            System.exit(0);
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
