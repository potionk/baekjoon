package bj1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        long a= Integer.parseInt(testCase[0]);
        int b= Integer.parseInt(testCase[1]);
        int c= Integer.parseInt(testCase[2]);
        System.out.println(splitMultiply(a%c,b,c));
    }
    public static long splitMultiply(long target, int expo, int rem){
        if(expo==1)
            return target;
        long half = splitMultiply(target, expo/2, rem);
        if(expo%2==0)
            return (half*half)%rem;
        else
            return (((half*half)%rem)*target)%rem;
    }
}