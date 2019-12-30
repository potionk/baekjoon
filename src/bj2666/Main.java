package bj2666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        String open[] = br.readLine().split(" ");
        int openA=Integer.parseInt(open[0]);
        int openB=Integer.parseInt(open[1]);
        int count=Integer.parseInt(br.readLine());
        int result=0;
        int[] in=new int[count];
        for(int i=0; i<count; i++){
            in[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0; i<count; i++){
            int input=in[i];
            int A=Math.abs(input-openA);
            int B=Math.abs(input-openB);
            if(A<B){
                openA-=(openA-input);
                result+=A;
            } else {
                openB -= (openB - input);
                result += B;
            }
//            } else{
//                if(i+1<count){
//                    int AA=Math.abs(in[i+1]-openA);
//                    int BB=Math.abs(in[i+1]-openB);
//                    if(AA<BB){
//                        openB-=(openB-input);
//                        result+=B;
//                    } else {
//                        openA -= (openA - input);
//                        result += A;
//                    }
//                } else {
//                    openB -= (openB - input);
//                    result += B;
//                }
//            }
        }
        System.out.println(result);
    }
}