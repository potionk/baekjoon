package bj1874;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int number= Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();
        for(int i=number; i>=1; i--){
            stack.push(i);
        }
        Stack<Integer> result=new Stack<>();
        int[] testCase=new int[number];
        for(int i=0; i<number; i++){
            testCase[i]= Integer.parseInt(br.readLine());
        }
        int cursor=-1;
        for(int i=0; i<number; i++){
            int target=testCase[i];
            if(target>cursor){
                boolean isFinish=false;
                while(!stack.isEmpty()){
                    if(stack.peek()==target){
                        isFinish=true;
                    }
                    result.push(stack.pop());
//                    bw.write("+\n");
                    sb.append("+\n");
                    if(isFinish){
                        result.pop();
//                        bw.write("-\n");
                        sb.append("-\n");
                        if(!result.isEmpty())
                            cursor=result.peek();
                        else
                            cursor=-1;
                        break;
                    }
                }
                if(!isFinish){
                    System.out.println("NO");
                    return;
                }
            } else {
                boolean isFinish=false;
                while(!result.isEmpty()&&!isFinish){
                    if(result.peek()==target){
                        isFinish=true;
                    }
                    result.pop();
//                    bw.write("-\n");
                    sb.append("-\n");
                    if(!result.isEmpty())
                        cursor=result.peek();
                    else
                        cursor=-1;
                }
                if(!isFinish){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
