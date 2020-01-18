package bj10989;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int MAX=10000000;
        int[] input=new int[size];
        int[] count=new int[MAX];
        int[] cumSum=new int[MAX];
        int[] result=new int[size];
        int maxValue=-1;
        for(int i=0; i<size; i++) {
            input[i] = Integer.parseInt(br.readLine());
            count[input[i]-1]++;
            if (input[i] > maxValue)
                maxValue = input[i];
        }
        cumSum[0]=count[0];
        for(int i=1; i<maxValue; i++){
            cumSum[i]=cumSum[i-1]+count[i];
        }
        for(int i=0; i<size; i++){
            result[--cumSum[input[i]-1]]=input[i];
        }
        for(int i=0; i<size; i++)
            bw.write(result[i]+"\n");
        bw.flush();
        bw.close();
    }
}