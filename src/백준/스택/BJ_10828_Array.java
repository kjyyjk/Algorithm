package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10828_Array {
    public static void main(String[] args) throws IOException {

        int i;
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(n);

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
    public static class ArrayStack{
        int top;
        int size;
        int[] stack;
        ArrayStack(int size){
            this.size = size;
            stack = new int[size];
            top = -1;
        }

        public void push(int x){
            top++;
            stack[top] = x;
        }

        public void pop(){
            if(top == -1){
                System.out.println(-1);
            }
            else{
                System.out.println(stack[top]);
                top--;
            }
        }

        public void size(){
            System.out.println(top+1);
        }

        public void empty(){
            if(top==-1){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }

        public void top(){
            if(top==-1){
                System.out.println(-1);
            }
            else{
                System.out.println(stack[top]);
            }
        }
    }
}
