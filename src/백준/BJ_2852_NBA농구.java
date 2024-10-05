package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2852_NBA농구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int score1 = 0;
        int score2 = 0;
        int time1 = 0;
        int time2 = 0;
        int lastGoal = 0;

        StringTokenizer st;
        int team;
        String temp;
        int t;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            team = Integer.parseInt(st.nextToken());
            temp = st.nextToken();
            t = Integer.parseInt((temp.split(":")[0])) * 60 + Integer.parseInt((temp.split(":")[1]));

            if (score1 < score2) {
                time2 += (t - lastGoal);
            } else if (score1 > score2) {
                time1 += (t - lastGoal);
            }

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            lastGoal = t;
        }

        if (score1 < score2) {
            time2 += (2880 - lastGoal);
        } else if (score1 > score2) {
            time1 += (2880 - lastGoal);
        }

        String ret1 = String.format("%02d", time1/60) + ":" + String.format("%02d", time1%60);
        String ret2 = String.format("%02d", time2/60) + ":" + String.format("%02d", time2%60);

        System.out.println(new StringBuilder().append(ret1).append('\n').append(ret2));
    }
}
