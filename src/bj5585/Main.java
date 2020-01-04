package bj5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay=Integer.parseInt(br.readLine());
        int diff=1000-pay;
        int count=0;
        int[] mode={500,100,50,10,5,1};
        int index=0;
        while(index!=5){
            if(diff>=mode[index]){
                diff-=mode[index];
                count++;
            } else {
                index++;
            }
        }
        System.out.println(count+diff);
    }
}