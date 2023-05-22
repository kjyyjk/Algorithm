import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int value = 1;
        int temp = 0;
        int count = 1;

        while (value<n){
            temp += 6;
            value += temp;
            count++;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(count));
    }
}
