import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a, b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        System.out.println((a>b)?a:b);
    }
}
