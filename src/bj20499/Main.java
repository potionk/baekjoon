package bj20499;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] kda=br.readLine().split("/");
        int k= Integer.parseInt(kda[0]);
        int d= Integer.parseInt(kda[1]);
        int a= Integer.parseInt(kda[2]);
        if(d==0||k+a<d){
            bw.write("hasu");
        } else {
            bw.write("gosu");
        }
        br.close();
        bw.close();
    }
}