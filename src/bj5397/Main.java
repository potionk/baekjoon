package bj5397;

import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            Stack<Character> result=new Stack<>();
            Stack<Character> temp=new Stack<>();
            char[] input=br.readLine().toCharArray();
            for(int j=0; j<input.length; j++){
                if(input[j]=='<'){
                    // result애서 pop후 temp로 옮겨옴
                    if(result.size()>0){
                        temp.push(result.pop());
                    }
                } else if(input[j]=='>'){
                    // temp에서 pop해서 result로 옮겨옴
                    if(temp.size()>0){
                        result.push(temp.pop());
                    }
                } else if(input[j]=='-'){
                    // result에서 pop
                    if(result.size()>0){
                        result.pop();
                    }
                } else {
                    result.push(input[j]);
                }
            }
            while(!temp.isEmpty()){
                result.push(temp.pop());
            }
            Object[] stack2Array=result.toArray();
            for(int j=0; j<stack2Array.length; j++){
                bw.write(stack2Array[j]+"");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}