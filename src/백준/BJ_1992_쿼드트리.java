package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {
    static int[][] a = new int[66][66];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }

        String ret = zip(0, 0, n);
        System.out.println(new StringBuilder().append(ret));
    }

    static String zip(int y, int x, int size) {
        int v = a[y][x];

        if (size == 1) {
            return Integer.toString(v);
        }

        String ret = "";
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                if (a[i][j] != v) {
                    ret += "(";
                    ret += zip(y, x, size/2);
                    ret += zip(y, x + size/2, size/2);
                    ret += zip(y + size/2, x, size/2);
                    ret += zip(y + size/2, x + size/2, size/2);
                    ret += ")";

                    return ret;
                }
            }
        }

        return Integer.toString(v);
    }
}
