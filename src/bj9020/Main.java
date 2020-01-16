package bj9020;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase= Integer.parseInt(br.readLine());
        boolean[] primeNum=new boolean[10000];
        primeNum[0]=true;
        for(int i=1; i<10000; i++){
            if(!primeNum[i]){
                for(int j=(i+1)*2-1; j<10000; j+=i+1){
                    primeNum[j]=true;
                }
            }
        }
        for(int i=0; i<testCase; i++){
            int tc= Integer.parseInt(br.readLine());
            int start=tc/2;
            for(int a=start; a>=1; a--){
                boolean isFind=false;
                if(!primeNum[a-1]){
                    for(int b=start; b<tc; b++){
                        if(!primeNum[b-1]&&a+b==tc){
                            bw.write(a+" "+b+"\n");
                            isFind=true;
                        }
                    }
                }
                if(isFind){
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}