package bj6321;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            char[] input=br.readLine().toCharArray();
            bw.write("String #"+(i+1)+"\n");
            for(int j=0; j<input.length; j++){
                if(input[j]!='Z')
                    bw.write((char)(input[j]+1));
                else
                    bw.write('A');
            }
            bw.write("\n\n");
        }
        bw.flush();
        bw.close();
    }
}