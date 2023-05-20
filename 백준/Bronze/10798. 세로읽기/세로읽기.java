import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[5][15];

        int row=0;
        int col=0;
        int maxLength = 1;


        for(row=0; row<5; row++){
            String s = br.readLine();

            if(maxLength<s.length()){
                maxLength = s.length();
            }

            for(col=0; col<s.length(); col++) {
                arr[row][col] = s.charAt(col);
            }
        }

        StringBuilder sb = new StringBuilder();
        int element;
        for(col=0; col<maxLength; col++){
            for(row=0; row<5; row++){
                element = arr[row][col];

                if (element != 0)
                    sb.append((char)element);
                else
                    sb.append("");
            }
        }
        System.out.println(sb);
    }
}
