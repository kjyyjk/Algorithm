import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        int i,num;

        Integer[] arr = new Integer[30];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(i=0; i<28; i++){
            arr[Integer.parseInt(br.readLine())-1] = 1;
        }

        StringBuilder sb = new StringBuilder();

        for(i=0; i<30; i++){
            if(arr[i] == null){
                sb.append(i+1 + "\n");
            }
        }

        System.out.println(sb);
    }
}
