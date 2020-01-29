package bj3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static char[] testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc= Integer.parseInt(br.readLine());
        int result=0;
        for(int i=0; i<tc; i++){
            char[] input=br.readLine().toCharArray();
            Stack<Character> stack=new Stack<>();
            stack.push(input[0]);
            for(int j=1; j<input.length; j++){
                stack.push(input[j]);
                int stackSize=stack.size();
                if(stackSize>=2&&stack.get(stackSize-1)==stack.get(stackSize-2)){
                    stack.pop();
                    stack.pop();
                }
            }
            if(stack.size()==0)
                result++;
        }
        System.out.println(result);
    }
}