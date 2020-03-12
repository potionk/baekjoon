package bj14888;

import java.io.*;

public class Main {
    static int[] operand; // 피연산자
    static int[] operator; // 연산
    static int size;
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size= Integer.parseInt(br.readLine());
        String[] operandStr=br.readLine().split(" ");
        String[] operatorStr=br.readLine().split(" ");
        operand=new int[operandStr.length];
        operator=new int[4];
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            operand[i]= Integer.parseInt(operandStr[i]);
        }
        for(int i=0; i<4; i++){
            operator[i]= Integer.parseInt(operatorStr[i]);
        }
        dfs(1, operand[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int index, int result) {
        if(index<size){
            int temp=result;
            for(int i=0; i<4; i++){
                if (operator[i]>0){
                    switch (i){
                        case 0:
                            result=result+operand[index];
                            break;
                        case 1:
                            result=result-operand[index];
                            break;
                        case 2:
                            result=result*operand[index];
                            break;
                        case 3:
                            result=result/operand[index];
                            break;
                    }
                    if(index==size-1){
                        max=Math.max(max, result);
                        min=Math.min(min, result);
                    }
                    --operator[i];
                    dfs(index+1, result);
                    result=temp;
                    ++operator[i];
                }
            }
        }
    }
}
