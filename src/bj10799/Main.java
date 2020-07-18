package bj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String testCase=br.readLine();
        int tcLen=testCase.length();
        int size=0;
        int result=0;
        for(int i=0; i<tcLen; i++){
            if(testCase.charAt(i)=='('){
                size++;
            } else {
                size--;
                if(testCase.charAt(i-1)=='('){
                    result+=size;
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}