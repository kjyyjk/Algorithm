import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double credit;
        String grade;
        double score=0;
        double totalCredit=0;
        double result = 0;

        for(int i=0; i<20; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();

            credit = Double.parseDouble(st.nextToken());
            grade = st.nextToken();


            if(grade.equals("P")){
                continue;
            }

            totalCredit += credit;


            switch (grade) {
                case "A+": {
                    score = 4.5;
                    break;
                }
                case "A0": {
                    score = 4.0;
                    break;
                }
                case "B+": {
                    score = 3.5;
                    break;
                }
                case "B0": {
                    score = 3.0;
                    break;
                }
                case "C+": {
                    score = 2.5;
                    break;
                }
                case "C0": {
                    score = 2.0;
                    break;
                }
                case "D+": {
                    score = 1.5;
                    break;
                }
                case "D0": {
                    score = 1.0;
                    break;
                }
                case "F": {
                    score = 0.0;
                    break;
                }
            }
            result += credit * score;
        }

        br.close();

        result = result / totalCredit;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.6f",result));
        System.out.println(sb);
    }
}