package bj11653;

import java.io.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input= Integer.parseInt(br.readLine());
        sb(input);
        bw.flush();
        bw.close();
        br.close();
    }
    public static int sb(int a) throws IOException {
        if(a==1)
            return 1;
        int i=2;
        while(a%i!=0){
            i++;
        }
        bw.write(i+"\n");
        return sb(a/i);
    }
}