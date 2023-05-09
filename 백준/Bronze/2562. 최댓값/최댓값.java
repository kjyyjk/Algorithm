import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0;
        int index = -1;
        int i;
        int[] arr = new int[9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>max){
                max = arr[i];
                index = i+1;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(max).append("\n").append(index);
        System.out.println(sb);
    }
}