import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =  new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine(), " ");
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine(), " ");
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int resultX, resultY;

        if(x1==x3)
            resultX = x2;
        else if (x1==x2)
            resultX = x3;
        else
            resultX = x1;

        if(y1==y3)
            resultY = y2;
        else if (y1==y2)
            resultY = y3;
        else
            resultY = y1;
        System.out.println(new StringBuilder().append(resultX).append(' ').append(resultY));
    }
}
