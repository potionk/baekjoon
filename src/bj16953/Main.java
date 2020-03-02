package bj16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int start= Integer.parseInt(testCase[0]);
        int finish= Integer.parseInt(testCase[1]);
        int count=1;
        while(true){
            count++;
            if(finish%2==0)
                finish=finish/2;
            else{
                if(finish%10!=1){
                    System.out.println(-1);
                    break;
                } else {
                    finish=finish/10;
                }
            }
            if(finish<start){
                System.out.println(-1);
                break;
            } else if(finish==start){
                System.out.println(count);
                break;
            }
        }
    }
}