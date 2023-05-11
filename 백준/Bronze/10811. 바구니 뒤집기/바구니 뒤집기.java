import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a,i,j,m,k;
        int count = 0;
        int[] basket;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        basket = new int[Integer.parseInt(st.nextToken())];

        for(a=0; a<basket.length; a++){
            basket[a] = a+1;
        }

        m = Integer.parseInt(st.nextToken());

        for(a=0; a<m; a++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken())-1;
            j = Integer.parseInt(st.nextToken())-1;

            while(i<j){
                k = basket[i];
                basket[i++] = basket[j];
                basket[j--] = k;
            }

        }

        StringBuilder sb = new StringBuilder();

        for(a=0; a<basket.length; a++){
            sb.append(basket[a]).append(' ');
        }
        System.out.println(sb);
    }
}
