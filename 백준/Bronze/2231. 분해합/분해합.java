import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int i,j,temp;
        int result = n;

        for(i=1; i<n; i++){
            temp = 0;
            String s = Integer.toString(i);
            for(j=0; j<s.length(); j++){
                temp+= Character.digit(s.charAt(j),10);
            }
            if(i+temp==n){
                if(result>i)
                    result = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(result == n)
            sb.append(0);
        else
            sb.append(result);

        System.out.println(sb);
    }
}
