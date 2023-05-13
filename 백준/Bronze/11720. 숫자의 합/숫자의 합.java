import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        int sum=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        String[] s = input.split("");

        for(i=0; i<n; i++){
            sum += Integer.parseInt(s[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        System.out.println(sb);
    }
}
