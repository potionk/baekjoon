package bj2711;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String[] input = br.readLine().split(" ");
            int typoIdx= Integer.parseInt(input[0]);
            int len=input[1].length();
            for(int j=0; j<len; j++){
                if(j==typoIdx-1){
                    continue;
                }
                bw.write(input[1].charAt(j));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}