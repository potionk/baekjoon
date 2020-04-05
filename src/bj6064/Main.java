package bj6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            int M= Integer.parseInt(input[0]);
            int N= Integer.parseInt(input[1]);
            int x= Integer.parseInt(input[2]);
            int y= Integer.parseInt(input[3]);
            int nextY=(x-1)%N+1;
            int count=x;
            boolean isFind=false;
            int lcm=lcm(M,N);
            while(count<=lcm){
                if(nextY==y){
                    isFind=true;
                    break;
                } else {
                    count+=M;
                    nextY=(nextY-1+M)%N+1;
                }
            }
            if(isFind)
                System.out.println(count);
            else
                System.out.println(-1);

        }
    }
    public static int gcd(int a, int b){ // 최대공약수
        if(a%b==0)
            return b;
        else
            return gcd(b,a%b);
    }

    public static int lcm(int a, int b){ // 최소공배수
        return a*b/gcd(a,b);
    }
}