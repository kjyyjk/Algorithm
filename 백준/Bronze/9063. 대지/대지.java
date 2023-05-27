import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x,y;
        int maxX=-10000;
        int maxY=-10000;
        int minX=10000;
        int minY=10000;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(x>maxX)
                maxX = x;

            if(x<minX)
                minX = x;

            if(y>maxY)
                maxY = y;

            if(y<minY)
                minY = y;

        }
        System.out.println(new StringBuilder().append((maxX-minX)*(maxY-minY)));
    }
}
