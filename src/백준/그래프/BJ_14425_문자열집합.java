package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14425_문자열집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tNode root = new tNode(false); //트라이의 루트 노드

        int i, j, nowChar;
        tNode nowTNode;
        for (i=0; i<n; i++) {
            String input = br.readLine();
            nowTNode = root;

            for (j=0; j<input.length(); j++) {
                nowChar = input.charAt(j) - 'a';

                if (nowTNode.next[nowChar] == null) {
                    nowTNode.next[nowChar] = new tNode(false);
                }

                nowTNode = nowTNode.next[nowChar];
                if (j == input.length()-1) { //끝 노드는 끝 표시
                    nowTNode.isEnd = true;
                }
            }
        }

        int result = 0;
        for (i=0; i<m; i++) {
            String input = br.readLine();
            nowTNode = root;

            for (j=0; j<input.length(); j++) {
                nowChar = input.charAt(j) - 'a';

                if (nowTNode.next[nowChar] == null) {
                    break;
                }

                nowTNode = nowTNode.next[nowChar];
                if (j == input.length()-1) {
                    if (nowTNode.isEnd == true) { //끝 노드이면
                        result++;
                    }
                }
            }
        }

        System.out.println(new StringBuilder().append(result));


    }

    static class tNode {
        tNode[] next;
        boolean isEnd;

        public tNode(boolean isEnd) {
            this.next = new tNode[26]; //26진 트라이
            this.isEnd = isEnd;
        }
    }
}