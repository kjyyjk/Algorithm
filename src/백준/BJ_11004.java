package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k-1);

        System.out.println(sb.append(arr[k-1]));
    }

    static void quickSort(int[] arr, int s, int e, int k) {
        if (s < e) {
            int pivotInd = partition(arr, s, e); //pivot은 정렬 후 고정된 인덱스.

            if (pivotInd == k) { //k랑 같으면 그냥 끝
                return;
            } else if (pivotInd > k) { //보다 크면 피벗 기준 왼쪽으로 재귀
                quickSort(arr, s, pivotInd - 1, k);
            } else { //보다 작으면 피벗 기준 오른쪽으로 재귀
                quickSort(arr, pivotInd + 1, e, k);
            }
        }
    }

    static int partition(int[] arr, int s, int e) {
        if(s+1 == e) { // 두 수만 정렬하면 되면 그냥 비교해서.
            if(arr[s] > arr[e]) {
                swap(arr, s, e);
            }
            return e;
        }

        int mid = (s+e)/2; //피벗을 중간 값으로
        swap(arr, s, mid); //i, j값 움직이기 편하게 피벗을 맨 앞으로
        int pivot = arr[s];

        int i = s+1;
        int j= e;

        while(i<=j) { //i>j가 되면 j자리가 pivot이 들어올 자리.
                    // i가 j를 넘어섰다는건, j와 그 앞은 피벗보다 작거나 같은 수라는 것이기 때문
            while (j>=s+1 && arr[j] > pivot) {
                j--;
            }

            while (i <= e && arr[i] < pivot) {
                i++;
            }

            if(i<=j) { //교차하지 않았을 경우 swap. i==j인 경우는 pivot과 해당 인덱스 값이 같을 때 해당
                swap(arr, i++, j--);
            }
        }

        swap(arr, s, j); //while문에서 나온 j는 피벗이 들어갈 자리. 다시 맨 앞과 swap.
        return j; //정렬 후 피벗의 인덱스를 return.
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
