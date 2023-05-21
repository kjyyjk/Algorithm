import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int jegob=n.length()-1;
        int result = 0;
        for(int i=0; i<n.length(); i++){
            char element = n.charAt(i);
            if(element<58){
                result += Math.pow(b,jegob) * (Character.getNumericValue(element));
            }
            else{
                result += Math.pow(b,jegob) * (element-55);
            }
            jegob--;
        }

        System.out.println(result);
    }
}
