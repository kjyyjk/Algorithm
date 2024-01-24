package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1406_에디터 {

    public static void main(String[] args) throws IOException {
        int i;
        myArrayList arrayList = new myArrayList();
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] init = br.readLine().toCharArray();

        for (char c : init) {   //초기값 삽입
            arrayList.P(c);
        }

        int m = Integer.parseInt(br.readLine());

        for (i = 0; i < m; i++) {
            input = br.readLine();
            switch (input.charAt(0)) {

                case 'L': {
                    arrayList.L();
                    break;
                }

                case 'D': {
                    arrayList.D();
                    break;
                }

                case 'B': {
                    arrayList.B();
                    break;
                }

                case 'P': {
                    arrayList.P(input.charAt(2));
                    break;
                }
            }
        }

        arrayList.print();
    }

    static class myArrayList {

        Node point; //문제 상 커서의 왼쪽 문자를 point로 두고 풀었다.
        Node dummy; //맨 앞 위치한 커서를 구현하기 위해 맨 앞에 dummy 노드 추가

        myArrayList() {
            dummy = new Node();
            point = dummy;
            dummy.left = null;
            dummy.right = null;
        }

        void L() {
            if (!isFront()) {
                point = point.left;
            }
        }

        void D() {
            if (!isBack()) {
                point = point.right;
            }
        }

        void B() {
            if (!isFront()) {   //문제의 조건(커서가 맨 앞이 아닐때만 동작)
                point.left.right = point.right;
                point = point.left;
                if (!isBack()) {    //만약 커서가 맨 끝에 위치해있다면
                    point.right.left = point;   //point.right가 null이기에 nullexception이 터지기 때문에 분기.
                }
            }
        }

        void P(char x) {
            Node newNode = new Node(x);
            if (!isBack()) {    //문자 사이에 집어 넣을 경우
                newNode.right = point.right;
                point.right.left = newNode;
                newNode.left = point;
                point.right = newNode;
                point = newNode;
            } else {    //문자 끝에 집어넣을 경우
                point.right = newNode;
                newNode.left = point;
                point = newNode;
            }
        }

        void print() {
            StringBuilder sb = new StringBuilder();
            Node printPoint = dummy.right;
            while (printPoint != null) {
                sb.append(printPoint.data);
                printPoint = printPoint.right;
            }
            System.out.println(sb);
        }

        boolean isFront() {
            if (point == dummy) {   //point가 dummy노드이면 커서가 맨 앞에 위치해있음을 의미.
                return true;
            }
            return false;
        }

        boolean isBack() {
            if (point.right == null) {  //point의 오른쪽 노드가 null이라면. 커서가 맨 마지막에 위치해있음을 의미.
                return true;
            }
            return false;
        }
    }

    static class Node {

        char data;
        Node left;
        Node right;

        Node() {
        }

        Node(char x) {
            this.data = x;
        }
    }
}