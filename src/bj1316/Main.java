package bj1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        int result=0;
        int[] alpha;
        for(int i=0; i<size; i++){
            alpha=new int[26];
            String input=br.readLine();
            boolean check=false;
            for(int j=0; j<input.length(); j++){
                int index=(int)input.charAt(j)-97;
                if(alpha[index]!=1)
                    alpha[index]=1;
                else{
                    check=true;
                }
                while(j+1<input.length()&&(int)input.charAt(j+1)-97==index){
                    j++;
                }
            }
            if(!check)
                result++;
        }
        System.out.println(result);
    }
}