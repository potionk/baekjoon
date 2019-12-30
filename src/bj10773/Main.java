package bj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<count; i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                stack.pop();
            } else{
                stack.push(input);
            }
        }
        if(stack.empty())
            System.out.println("0");
        else {
            int total = 0;
            while(!stack.empty()){
                total += stack.pop();
            }
            System.out.println(total);
        }
    }
}