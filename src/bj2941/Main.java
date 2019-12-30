package bj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croatia=new String[8];
        croatia[0]="c=";
        croatia[1]="c-";
        croatia[2]="dz=";
        croatia[3]="d-";
        croatia[4]="lj";
        croatia[5]="nj";
        croatia[6]="s=";
        croatia[7]="z=";
        String input=br.readLine();
        int result=0;
        boolean flag=true;
        while(flag) {
            flag=false;
            for (int i = 0; i < croatia.length; i++) {
                result = input.indexOf(croatia[i]);
                if (result != -1) {
                    if (i != 2) {
                        if (result - 1 < 0)
                            input = input.substring(result + 2) + " ";
                        else
                            input = input.substring(0, result) + " " + input.substring(result + 2);
                    } else {
                        if (result - 1 < 0)
                            input = input.substring(result + 3) + " ";
                        else
                            input = input.substring(0, result) + " " + input.substring(result + 3);
                    }
                    flag=true;
                }
            }
        }
        System.out.println(input.length());
    }
}
