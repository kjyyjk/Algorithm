import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int n,m,a,b,i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] basketArr = new int[n];

        for(a=0; a<m; a++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for(b=i-1;b<j;b++){
                basketArr[b] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(i=0; i<basketArr.length; i++){
            sb.append(basketArr[i] + " ");
        }

        System.out.println(sb);
    }
}