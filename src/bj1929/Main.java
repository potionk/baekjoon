package bj1929;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split(" ");
        int min= Integer.parseInt(input[0]);
        int max= Integer.parseInt(input[1]);
        boolean[] primeNum=new boolean[max];
        primeNum[0]=true;
        for(int i=1; i<max; i++){
            if(!primeNum[i]){
                for(int j=(i+1)*2-1; j<max; j+=i+1){
                    primeNum[j]=true;
                }
            }
        }
        for(int i=min-1; i<max; i++){
            if(!primeNum[i])
                bw.write(i+1+"\n");
        }
        bw.flush();
        bw.close();
    }
}