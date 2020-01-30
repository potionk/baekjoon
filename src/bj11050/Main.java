package bj11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int K= Integer.parseInt(testCase[1]);
        System.out.println(factorial(N)/(factorial(K)*factorial(N-K)));
    }
    public static int factorial(int input){
        int result=1;
        while(input!=0){
            result*=input--;
        }
        return result;
    }
}