package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11399_ATM {

    public static void main(String[] args) throws IOException {

        int n, i, j, index, sortNum, result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sumArr = new int[n];

        for(i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //선택정렬
        for(i=1; i<n; i++) {
            index = i;
            sortNum = arr[i];

            for(j=0; j<i; j++) { //삽입할 위치 찾기
                if(arr[j]+1 > sortNum) {
                    index = j;
                    break;
                }
            }

            if(index == i) { //삽입할 위치가 그대로라면 종료
                continue;
            } else {
                for(j=i; j>index; j--) { //삽입할 위치까지 뒤에서부터 shift
                    arr[j] = arr[j-1];
                }
                arr[index] = sortNum; //삽입
            }
        }

        //구간합배열 sumArr 이용
        sumArr[0] = arr[0];
        result = sumArr[0];

        for(i=1; i<n; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
            result += sumArr[i];
        }

        System.out.println(sb.append(result));
    }
}
