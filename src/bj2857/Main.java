package bj2857;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean findCheck=false;
        for(int i=0; i<5; i++){
            String input=br.readLine();
            if(input.contains("FBI")){
                System.out.print(i+1+" ");
                findCheck=true;
            }
        }
        if(!findCheck)
            System.out.print("HE GOT AWAY!");
    }
}