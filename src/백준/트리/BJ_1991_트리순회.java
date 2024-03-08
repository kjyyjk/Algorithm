package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1991_트리순회 {

    static Node[] tree;
    static StringBuilder preOrderResult = new StringBuilder();
    static StringBuilder inOrderResult = new StringBuilder();
    static StringBuilder postOrderResult = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];

        int i, ind, leftInd, rightInd;
        char left, right;
        StringTokenizer st;
        for (i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            ind = st.nextToken().charAt(0) - 'A';
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            if (left == '.') {
                leftInd = -1;
            } else {
                leftInd = left - 'A';
            }

            if (right == '.') {
                rightInd = -1;
            } else {
                rightInd = right - 'A';
            }

            tree[ind] = new Node(leftInd, rightInd);
        }

        preOrder(0);
        inOrder(0);
        postOrder(0);

        System.out.println(preOrderResult);
        System.out.println(inOrderResult);
        System.out.println(postOrderResult);
    }

    static void preOrder(int a) {
        if (a == -1) {
            return;
        }
        preOrderResult.append((char)(a+'A'));
        preOrder(tree[a].left);
        preOrder(tree[a].right);
    }

    static void inOrder(int a) {
        if (a == -1) {
            return;
        }
        inOrder(tree[a].left);
        inOrderResult.append((char)(a+'A'));
        inOrder(tree[a].right);
    }

    static void postOrder(int a) {
        if (a == -1) {
            return;
        }
        postOrder(tree[a].left);
        postOrder(tree[a].right);
        postOrderResult.append((char)(a+'A'));
    }

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
