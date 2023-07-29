package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10828_Linked {
    public static void main(String[] args) throws IOException {

        int i;
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedStack stack = new LinkedStack();

        for(i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command){
                case "push": {
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                }

                case "pop": {
                    stack.pop();
                    break;
                }

                case "size":{
                    stack.size();
                    break;
                }

                case "empty": {
                    stack.empty();
                    break;
                }

                case "top": {
                    stack.top();
                    break;
                }
            }
        }

    }
    public static class LinkedStack{
        Node top;
        int count; // 스택 길이

        LinkedStack(){
            this.top = null;
            this.count = 0;
        }

        public void push(int x){
            Node newNode = new Node(x);
            if(top == null){
                top = newNode;
            }
            else{
                newNode.link = top;
                top = newNode;
            }
            count++;
        }

        public void pop(){
            if(top==null){
                System.out.println(-1);
            } else{
                System.out.println(top.data);
                top = top.link;
                count --;
            }
        }

        public void size() {
            System.out.println(count);
        }

        public void empty(){
            if(top == null){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }

        public void top(){
            if(top == null){
                System.out.println(-1);
            }else{
                System.out.println(top.data);
            }
        }

        private class Node{
            int data;
            Node link;

            Node(int data){
                this.data = data;
                this.link = null;
            }
        }
    }
}
