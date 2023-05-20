import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, j;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        for (i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (j = 0; j < m; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                sb.append(arr1[i][j]+arr2[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
