package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 경우의 수를 판단하는 문제이며, n의 범위가 30이하이다. -> 비트 마스킹 고려
 * 
 * 비트마스킹으로 각 경우를 만든다.
 * solve()에서 파라미터로 받은 해당 경우가 영양분 조건을 만족하는지 확인한다.
 * 만족하면서 cost보다 최소 비용이면 cost를 갱신하고 result를 초기화한 뒤 식재료 문자열을 추가한다.
 * 만족하면서 cost와 같으면 result에 식재료 문자열을 추가한다.
 * 모든 경우의 수를 체크한 뒤, cost에 변화가 없으면 -1을 출력한다.
 * cost가 갱신되었으면 cost를 출력하고, result를 오름차순 정렬하여 첫번째 문자열을 출력한다.
 */
public class BJ_19942_다이어트 {
    static int n, mp, mf, ms, mv, cost;
    static List<String> result;
    static int[] pArr;
    static int[] fArr;
    static int[] sArr;
    static int[] vArr;
    static int[] cArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pArr = new int[n + 4];
        fArr = new int[n + 4];
        sArr = new int[n + 4];
        vArr = new int[n + 4];
        cArr = new int[n + 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pArr[i] = Integer.parseInt(st.nextToken());
            fArr[i] = Integer.parseInt(st.nextToken());
            sArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
            cArr[i] = Integer.parseInt(st.nextToken());
        }

        cost = 15000;
        result = new ArrayList<>();
        for (int i = 1; i < (1 << n); i++) { // 비트마스킹으로 각 경우의 수 체크
            solve(i);
        }

        StringBuilder sb = new StringBuilder();
        if (cost == 15000) {
            sb.append(-1).append('\n');
        } else {
            sb.append(cost).append('\n');
            Collections.sort(result); // 오름차순 정렬
            sb.append(result.get(0));
        }
        System.out.println(sb);
    }

    static void solve(int num) {
        int p = 0;
        int f = 0;
        int s = 0;
        int v = 0;
        int c = 0;
        String ret = "";
        for (int i = 0; i < n; i++) {
            if ((num & (1 << i)) != 0) {
                p += pArr[i];
                f += fArr[i];
                s += sArr[i];
                v += vArr[i];
                c += cArr[i];
                ret = ret + (i + 1) + " ";
            }
        }
        if (p < mp || f < mf || s < ms || v < mv) return; // 영양분 조건 불만족
        if (cost > c) { // 갱신
            cost = c;
            result.clear();
            result.add(ret);
        } else if (cost == c) { // 문자열만 추가
            result.add(ret);
        }
    }
}