package bj1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] testCase=br.readLine().toCharArray();
        Stack<Character> result=new Stack<>();
        Stack<Character> operator=new Stack<>();
        for(int i=0; i<testCase.length; i++){
            switch (testCase[i]){
                case '+':
                case '-':
                    while(!operator.isEmpty()&&operator.peek()!='('){
                        result.push(operator.pop());
                    }
                    operator.push(testCase[i]);
                    break;
                case '/':
                case '*':
                    while(!operator.isEmpty()&&(operator.peek()=='/'||operator.peek()=='*')){
                        result.push(operator.pop());
                    }
                    operator.push(testCase[i]);
                    break;
                case '(':
                    operator.push(testCase[i]);
                    break;
                case ')':
                    while(operator.peek()!='(')
                        result.push(operator.pop());
                    operator.pop();
                    break;
                default:
                    result.push(testCase[i]);
            }
            if(i==testCase.length-1){
                while(operator.size()!=0)
                    result.push(operator.pop());
            }
        }
        Object[] result2Array=result.toArray();
        for(int i=0; i<result2Array.length; i++){
            System.out.print(result2Array[i]);
        }
    }
}