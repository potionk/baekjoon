package bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int k=0; k<testCase; k++){
            Stack<Character> stack=new Stack<>();
            String input=br.readLine();
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='(')
                    stack.push(input.charAt(i));
                else if(input.charAt(i)==')'&&stack.size()>0&&stack.peek()=='(')
                    stack.pop();
                else if(input.charAt(i)==')'&&(stack.size()==0||stack.peek()!='(')){
                    stack.push('e');
                    break;
                }
            }
            if(stack.size()>0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}