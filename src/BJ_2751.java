import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] inputArr = new int[n];

        for(int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        int[] resultArr = mergeSort(inputArr);

        for(int i=0; i<n; i++) {
            sb.append(resultArr[i]).append('\n');
        }

        System.out.println(sb);
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length==1) {
            int[] returnArr = new int[1];
            returnArr[0] = arr[0];
            return returnArr;
        } else {
            int[] fArr = new int[arr.length/2];
            int[] bArr = new int[arr.length - fArr.length];

            int tempInd = 0;

            for(int i=0; i<arr.length/2; i++) {
                fArr[tempInd++] = arr[i];
            }

            tempInd = 0;

            for(int i=arr.length/2; i<arr.length; i++) {
                bArr[tempInd++] = arr[i];
            }

            return merge(mergeSort(fArr), mergeSort(bArr));
        }
    }

    static int[] merge(int[] aArr, int[] bArr) {
        int[] mergeArr = new int[aArr.length + bArr.length];
        int mergeInd = 0;
        int i = 0;
        int j = 0;

        while((i!=aArr.length && j!=bArr.length)) {
            if(aArr[i] > bArr[j]) {
                mergeArr[mergeInd++] = bArr[j++];
            } else {
                mergeArr[mergeInd++] = aArr[i++];
            }
        }

        if(i==aArr.length) {
            while(j<bArr.length) {
                mergeArr[mergeInd++] = bArr[j++];
            }
        } else if(j==bArr.length){
            while(i<aArr.length) {
                mergeArr[mergeInd++] = aArr[i++];
            }
        }
        return mergeArr;
    }
}
