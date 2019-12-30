package bj4673;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int count=0;
        if(Integer.parseInt(input)<10){
            input="0"+input;
        }
        String temp=input;
        while(true){
            int result=Integer.parseInt(input.charAt(0)+"")+Integer.parseInt(input.charAt(1)+"");
            result=result%10;
            input=input.charAt(1)+""+result;
            count++;
            if(input.equals(temp)){
                System.out.println(count);
                break;
            }
        }
    }
}