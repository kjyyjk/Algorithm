import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(n!=0){
            int i = n%b;
            if(i<10)
                sb.append(i);
            else{
                char c = (char) (i+55);
                sb.append(c);
            }
            n/=b;
        }
        System.out.println(sb.reverse());
    }
}
