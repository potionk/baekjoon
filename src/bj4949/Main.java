package bj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input;
        while((input=br.readLine().toCharArray()).length!=1&&input[0]!='.'){
            Stack<Character> stack=new Stack<>();
            for(int i=0; i<input.length; i++){
                if(input[i]=='['||input[i]=='(')
                    stack.push(input[i]);
                else if(input[i]==']'&&stack.size()>0&&stack.peek()=='[')
                    stack.pop();
                else if(input[i]==']'&&(stack.size()==0||stack.peek()!='[')){
                    stack.push('e');
                    break;
                }
                else if(input[i]==')'&&stack.size()>0&&stack.peek()=='(')
                    stack.pop();
                else if(input[i]==')'&&(stack.size()==0||stack.peek()!='(')){
                    stack.push('e');
                    break;
                }
            }
            if(stack.size()>0)
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}