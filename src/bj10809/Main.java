package bj10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int alphabet[]=new int[26];
        for(int i=0; i<alphabet.length; i++){
            alphabet[i]=-1;
        }
        for(int i=0; i<input.length(); i++){
            for(int j=0; j<alphabet.length; j++){
                if((int)input.charAt(i)==j+97&&alphabet[j]==-1)
                    alphabet[j]=i;
            }
        }
        for(int i=0; i<alphabet.length; i++){
            System.out.print(alphabet[i]+" ");
        }
    }
}