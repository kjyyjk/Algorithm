import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = br.readLine().charAt(0);

        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        System.out.println(sb);
    }
}
