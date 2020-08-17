package bj15792;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        long A=Long.parseLong(tc[0]);
        long B=Long.parseLong(tc[1]);
        long div=A/B;
        long rem=A%B;
        if(A<0){
            if(B<0){
                div++;
                rem-=B;
            } else {
                div--;
                rem+=B;
            }
        }
        System.out.println(div);
        System.out.println(rem);
    }
}