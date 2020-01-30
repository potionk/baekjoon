package bj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack=new Stack<>();
        int testCase= Integer.parseInt(br.readLine());
        double[] data=new double[testCase];
        char[] expr=br.readLine().toCharArray();
        for(int i=0; i<testCase; i++){
            data[i]= Double.parseDouble(br.readLine());
        }
        for(int i=0; i<expr.length; i++){
            double b;
            double a;
            switch (expr[i]){
                case '+':
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a+b);
                    break;
                case '-':
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a-b);
                    break;
                case '*':
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a*b);
                    break;
                case '/':
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(data[expr[i]-65]);
            }
        }
        System.out.println(String.format("%.2f",stack.get(0)));
    }
}