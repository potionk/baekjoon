package bj9933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] hackedFile=new String[num];
        for(int i=0; i<num; i++){
            hackedFile[i]=br.readLine();
        }
        for(int i=0; i<num-1; i++){
            for(int j=i; j<num; j++){
                if(hackedFile[i].equals(reverseString(hackedFile[j])))
                    System.out.println(hackedFile[i].length()+" "+hackedFile[i].charAt(hackedFile[i].length()/2));
            }
        }
    }
    public static String reverseString(String input) {
        return (new StringBuffer(input)).reverse().toString();
    }
}