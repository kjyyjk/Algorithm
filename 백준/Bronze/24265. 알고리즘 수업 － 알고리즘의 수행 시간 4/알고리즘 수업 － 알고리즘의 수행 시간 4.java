import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        //i=1 부터 n-1까지 (n-i)를 더해야함. 시그마 이용하여 풀면
        //(n^2 - n) / 2
        System.out.println(new StringBuilder().append(n*(n-1)/2).append('\n').append(2).append('\n'));
    }
}
