package bj4948;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> testCase=new LinkedList<>();
        String input;
        int max=-1;
        while(!(input=br.readLine()).equals("0")){
            int tc2int= Integer.parseInt(input);
            if(tc2int>max)
                max=tc2int;
            testCase.add(tc2int);
        }
        max*=2;
        max++;
        boolean[] primeNum=new boolean[max];
        primeNum[0]=true;
        for(int i=1; i<max; i++){
            if(!primeNum[i]){
                for(int j=(i+1)*2-1; j<max; j+=i+1){
                    primeNum[j]=true;
                }
            }
        }
        Object[] testCaseArray=testCase.toArray();
        for(int i=0; i<testCaseArray.length; i++){
            int tcMin=(int)testCaseArray[i];
            int tcMax=(int)testCaseArray[i]*2;
            int count=0;
            for(int j=tcMin+1; j<=tcMax; j++){
                if(!primeNum[j-1])
                    count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}