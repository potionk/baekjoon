package bj1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int alphabet[]=new int[26];
        int large=-1;
        int index=0;
        boolean status=false;
        for(int i=0; i<input.length(); i++){
            for(int j=0; j<alphabet.length; j++){
                if((int)input.charAt(i)==97+j||(int)input.charAt(i)==65+j){
                    alphabet[j]++;
                }
            }
        }
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i]>large)
                large=alphabet[i];
        }
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i]==large&&status==true){
                System.out.println("?");
                return;
            } else if(alphabet[i]==large){
                index=i;
                status=true;
            }
        }
        System.out.println((char)(index+65));
    }
}
