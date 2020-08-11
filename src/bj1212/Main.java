package bj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] tc=br.readLine().toCharArray();
        String[] firstBinary={"0","1","10","11","100","101","110","111"};
        String[] binary={"000","001","010","011","100","101","110","111"};
        System.out.print(firstBinary[tc[0]-'0']);
        for(int i=1; i<tc.length; i++){
            System.out.print(binary[tc[i]-'0']);
        }
    }
}
