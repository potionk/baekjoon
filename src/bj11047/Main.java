package bj11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int[] coin=new int[Integer.parseInt(input[0])];
        int result=0;
        int wallet=Integer.parseInt(input[1]);
        for(int i=0; i<Integer.parseInt(input[0]); i++){
            coin[i]=Integer.parseInt(br.readLine());
        }
        while(wallet>0) {
            int index=0;
            for (int i = 0; i < Integer.parseInt(input[0]); i++) {
                if (wallet < coin[i]) {
                    index=i-1;
                    break;
                } else if(i == Integer.parseInt(input[0])-1&&wallet>coin[i]){
                    index=i;
                    break;
                }
            }
            int num=wallet/coin[index];
            wallet-=coin[index]*num;
            result+=num;
        }
        System.out.println(result);
    }
}