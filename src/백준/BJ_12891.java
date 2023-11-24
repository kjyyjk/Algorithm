package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, j;
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;

        char[] dnaArr = br.readLine().toCharArray();
        char temp;
        int[] checkArr = new int[4];
        int[] myArr = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for(i=0; i<4; i++) {
            checkArr[i] += Integer.parseInt(st.nextToken());
        }

        for(i=0; i<p; i++) {
            temp = dnaArr[i];

            if(temp == 'A') {
                myArr[0]++;
            } else if(temp == 'C') {
                myArr[1]++;
            } else if(temp == 'G') {
                myArr[2]++;
            } else {
                myArr[3]++;
            }
        }

        if(check(myArr, checkArr)) {
            result++;
        }

        for(j=p; j<s; j++) {
            i = j - p;

            if (dnaArr[i] == 'A') {
                myArr[0]--;
            } else if (dnaArr[i] == 'C') {
                myArr[1]--;
            } else if (dnaArr[i] == 'G') {
                myArr[2]--;
            } else {
                myArr[3]--;
            }

            if (dnaArr[j] == 'A') {
                myArr[0]++;
            } else if (dnaArr[j] == 'C') {
                myArr[1]++;
            } else if (dnaArr[j] == 'G') {
                myArr[2]++;
            } else {
                myArr[3]++;
            }

            if(check(myArr, checkArr)) {
                result++;
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

    public static boolean check(int[] my, int[] check) {

        for(int i=0; i<4; i++) {
            if(my[i] < check[i]) {
                return false;
            }
        }
        return true;
    }

}
