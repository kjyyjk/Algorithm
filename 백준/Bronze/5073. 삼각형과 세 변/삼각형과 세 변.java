import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, c, max;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            max = Math.max(Math.max(a,b),c);
            if(max>=a+b+c-max && a!=0) {
                sb.append("Invalid\n");
            }
            else if(a==b&&b==c){
                if(a==0)
                    break;
                else
                    sb.append("Equilateral\n");
            }
            else if (a==b || b==c || a==c)
                sb.append("Isosceles\n");
            else
                sb.append("Scalene\n");
        }
        br.close();
        System.out.println(sb);
    }
}
