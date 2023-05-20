import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k;
        int max = -1;
        int maxRow=-1;
        int maxCol=-1;

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                if(max < (k = Integer.parseInt(st.nextToken()))){
                    maxRow = i+1;
                    maxCol = j+1;
                    max = k;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(maxRow).append(' ').append(maxCol);
        System.out.println(sb);
    }
}
