package bj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] bomb;
    static char[] str;
    static int start;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine().toCharArray();
        bomb=br.readLine().toCharArray();

        boolean found = false;
        do {
            if (find()) {
                char[] afterBomb=new char[str.length-bomb.length];
                for(int i=0; i<start; i++){
                    afterBomb[i]=str[i];
                }
                for(int i=end; i<str.length; i++){
                    afterBomb[i-bomb.length]=str[i];
                }
                str=afterBomb;
                found = true;
            } else {
                found = false;
            }
        } while(found);
        if(str.length==0)
            System.out.println("FRULA");
        else{
            for(int i=0; i<str.length; i++){
                System.out.print(str[i]);
            }
        }
    }
    public static boolean find(){
        boolean isBomb=true;
        if(str.length-bomb.length+1<0)
            return false;
        for(int i=0; i<str.length-bomb.length+1; i++){
            isBomb=true;
            for(int j=i; j<bomb.length+i; j++){
                if(str[j]!=bomb[j-i]){
                    isBomb=false;
                    break;
                }
            }
            if(isBomb){
                start=i;
                end=i+bomb.length;
                break;
            }
        }
        if(isBomb)
            return true;
        else
            return false;
    }
}