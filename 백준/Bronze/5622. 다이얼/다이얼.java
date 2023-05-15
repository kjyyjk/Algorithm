import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int i, result = 0;

        for(i=0; i<s.length(); i++){
            char alpha = s.charAt(i);

            switch (alpha){
                case 'A' : case 'B' : case 'C' :
                    result += 3; break;
                case 'D' : case 'E' : case 'F' :
                    result += 4; break;
                case 'G' : case 'H' : case 'I' :
                    result += 5; break;
                case 'J' : case 'K' : case 'L' :
                    result += 6; break;
                case 'M' : case 'N' : case 'O' :
                    result += 7; break;
                case 'P' : case 'Q' : case 'R' : case 'S':
                    result += 8; break;
                case 'T' : case 'U' : case 'V' :
                    result += 9; break;
                case 'W' : case 'X' : case 'Y' : case 'Z' :
                    result += 10; break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}
