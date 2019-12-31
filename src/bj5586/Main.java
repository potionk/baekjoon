package bj5586;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine();
        int joiCount=0;
        int ioiCount=0;
        for(int i=0; i<input.length()-2; i++){
            if(isJoi(i))
                joiCount++;
            else if(isioi(i))
                ioiCount++;
        }
        System.out.println(joiCount);
        System.out.println(ioiCount);
    }

    static boolean isJoi(int index){
        if(input.charAt(index)=='J'&&input.charAt(index+1)=='O'&&input.charAt(index+2)=='I')
            return true;
        return false;
    }

    static boolean isioi(int index){
        if(input.charAt(index)=='I'&&input.charAt(index+1)=='O'&&input.charAt(index+2)=='I')
            return true;
        return false;
    }
}