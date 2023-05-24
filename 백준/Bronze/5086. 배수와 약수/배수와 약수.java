import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int x,y;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(x==0 && y==0){
                break;
            }
            else if(x%y==0)
                sb.append("multiple\n");
            else if (y%x==0)
                sb.append("factor\n");
            else
                sb.append("neither\n");
        }

        System.out.println(sb);
    }
}
