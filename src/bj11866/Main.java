package bj11866;

import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] testCase=br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int K= Integer.parseInt(testCase[1]);
        int[] yose=new int[N];
        boolean[] isVisited=new boolean[N];
        int[] result=new int[N];
        for(int i=0; i<yose.length; i++){
            yose[i]=i+1;
        }
        int index=-1;
        int count=0;
        int resultIndex=0;
        while(resultIndex!=N){
            for(int i=0; i<K; i++){
                index++;
                if(index==N)
                    index=0;
                if(isVisited[index])
                    i--;
            }
            isVisited[index]=true;
            result[resultIndex]=yose[index];
            resultIndex++;
        }
        bw.write("<");
        for(int i=0; i<result.length; i++){
            if(i!=result.length-1)
                bw.write(result[i]+", ");
            else
                bw.write(result[i]+">");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}