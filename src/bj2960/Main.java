package bj2960;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split(" ");
        int N= Integer.parseInt(input[0]);
        int count= Integer.parseInt(input[1]);
        boolean[] primeNum=new boolean[N+1];
        primeNum[0]=true;

        for(int i=2; i<=N; i++){
            if(!primeNum[i]){
                for(int j=i; j<=N; j+=i){
                    if(!primeNum[j]&&--count==0)
                        System.out.println(j);
                    primeNum[j]=true;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}