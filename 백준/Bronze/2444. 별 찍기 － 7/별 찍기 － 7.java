import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        int i,t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        int blank =n-1;
        int star =1;

        StringBuilder sb = new StringBuilder();

        for(i=0; i<2*n-1; i++){

            for(t=0; t<blank; t++)
                sb.append(" ");
            for(t=0; t<star; t++)
                sb.append("*");

            sb.append("\n");

            if(i<n-1){
                blank-=1;
                star+=2;
            }
            else{
                blank+=1;
                star-=2;
            }
        }
        System.out.println(sb);
    }
}
