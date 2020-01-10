package bj6603;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String[] input=br.readLine().split(" ");
            if(input[0].equals("0"))
                break;
            int num= Integer.parseInt(input[0]);
            int[] S=new int[num];
            for(int i=0; i<S.length; i++){
                S[i]= Integer.parseInt(input[i+1]);
            }
            Arrays.sort(S);
            for(int a=0; a<S.length-5; a++)
                for(int b=a+1; b<S.length-4; b++)
                    for(int c=b+1; c<S.length-3; c++)
                        for(int d=c+1; d<S.length-2; d++)
                            for(int e=d+1; e<S.length-1; e++)
                                for(int f=e+1; f<S.length; f++)
                                    bw.write(S[a]+" "+S[b]+" "+S[c]+" "+S[d]+" "+S[e]+" "+S[f]+"\n");

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}


/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
 */