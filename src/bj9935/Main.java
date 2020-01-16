package bj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack=new Stack<>();
        char[] input=br.readLine().toCharArray();
        int inputSize=input.length;
        char[] bomb=br.readLine().toCharArray();
        int bombSize=bomb.length;
        for(int i=inputSize-1; i>=0; i--){
            stack.push(input[i]);
            int stackSize=stack.size();
            if(stackSize>=bombSize){
                boolean isBomb=true;
                for(int j=stackSize-bombSize, bombIndex=bombSize-1; j<stackSize; j++, bombIndex--){
                    if(stack.get(j)!=bomb[bombIndex]){
                        isBomb=false;
                        break;
                    }
                }
                if(isBomb){
                    for(int j=0; j<bombSize; j++){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty())
            System.out.println("FRULA");
        else{
            int stackSize=stack.size();
            for(int i=0; i<stackSize; i++){
                System.out.print(stack.pop());
            }
        }
    }
}