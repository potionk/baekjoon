package bj2693;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            int[] tc=new int[10];
            String[] tcStr=br.readLine().split(" ");
            for(int j=0; j<10; j++){
                tc[j]= Integer.parseInt(tcStr[j]);
            }
            Arrays.sort(tc);
            bw.write(tc[7]+"\n");
        }
        bw.flush();
    }
}
