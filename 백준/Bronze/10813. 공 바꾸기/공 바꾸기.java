import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int n,m,a,i,j,temp;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] basketArr = new int[n];

        for(a=0; a<n; a++) {
            basketArr[a] = a+1;
        }

        for(a=0; a<m; a++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            temp = basketArr[i-1];
            basketArr[i-1] = basketArr[j-1];
            basketArr[j-1] = temp;
        }

        StringBuilder sb = new StringBuilder();

        for(a=0; a<basketArr.length; a++){
            sb.append(basketArr[a] + " ");
        }
        System.out.println(sb);
    }
}
