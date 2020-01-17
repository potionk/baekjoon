package bj1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            int x1= Integer.parseInt(input[0]);
            int y1= Integer.parseInt(input[1]);
            int r1= Integer.parseInt(input[2]);
            int x2= Integer.parseInt(input[3]);
            int y2= Integer.parseInt(input[4]);
            int r2= Integer.parseInt(input[5]);
//            double d=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
            int d=(x2-x1)*(x2-x1) + (y2-y1)*(y2-y1); // d 제곱
            if(r1>r2){
                int temp=r1;
                r1=r2;
                r2=temp;
            }
            if(x1==x2&&y1==y2&&r1==r2) {
                System.out.println(-1);
            } else if (d>(r1+r2)*(r1+r2)||(x1==x2&&y1==y2&&r1!=r2)||d<(r1-r2)*(r1-r2)){
                System.out.println(0);
            } else if((r2+r1)*(r2+r1)==d||(r2-r1)*(r2-r1)==d){
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}