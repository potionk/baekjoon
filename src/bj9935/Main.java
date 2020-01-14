package bj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] bomb;
    static boolean[] liveStr;
    static char[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine().toCharArray();
        bomb=br.readLine().toCharArray();
        liveStr=new boolean[str.length];

        boolean found;
        do {
            if (find()) {
                found = true;
            } else {
                found = false;
            }
        } while(found);
        if(str.length==0)
            System.out.println("FRULA");
        else{
            boolean isEmpty=true;
            for(int i=0; i<str.length; i++){
                if(liveStr[i])
                    continue;
                System.out.print(str[i]);
                isEmpty=false;
            }
            if(isEmpty)
                System.out.println("FRULA");
        }
    }
    public static boolean find(){
        boolean isBomb=false;
        int[] bombIndex=new int[bomb.length];
        for(int i=0; i<str.length-bomb.length+1; i++){
            int t=0;
            if(liveStr[i])
                continue;
            isBomb=true;
            for(int j=i; j<bomb.length+i+t; j++){
                while(liveStr[j]){
                    j++;
                    t++;
                    if(j>liveStr.length-bomb.length+(j-i))
                        break;
                }
                if(j>liveStr.length-bomb.length+(j-i))
                    break;
                if(str[j]!=bomb[j-i-t]){
                    isBomb=false;
                    break;
                }
                bombIndex[j-i-t]=j;
            }
            if(isBomb){
                for(int j=0; j<bombIndex.length; j++){
                    liveStr[bombIndex[j]]=true;
                }
                break;
            }
        }
        if(isBomb)
            return true;
        else
            return false;
    }
}