package bj3613;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        char[] testCase=br.readLine().toCharArray();
        boolean isCpp=false;
        boolean isJava=false;
        boolean isError=false;
        for(int i=0; i<testCase.length; i++){
            if(testCase[i]==' '){
                isError=true;
                break;
            }
            if(i==0&&(testCase[i]<=90||testCase[i]=='_')){
                isError=true;
                break;
            }
            if(testCase[i]=='_') {
                isCpp=true;
                if(i==testCase.length-1){
                    isError=true;
                    continue;
                }
                if((testCase[i + 1]=='_')||testCase[i+1]<=90)
                    isError=true;
                bw.write((char)(testCase[i + 1] - 32)+"");
                i++;
            } else if(testCase[i]<=90){
                isJava=true;
                bw.write("_");
                bw.write((char)(testCase[i] + 32)+"");
            } else
                bw.write(testCase[i]);
        }
        if((isCpp&&isJava)||isError)
            System.out.println("Error!");
        else
            bw.flush();
    }
}