package bj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] soldBooks=new String[num];
        for(int i=0; i<num; i++){
            soldBooks[i]=br.readLine();
        }
        Arrays.sort(soldBooks);
        String bestSeller="";
        String previousBook=soldBooks[num-1];
        int bestSellerCount=-1;
        int count=0;
        for(int i=num-1; i>=0; i--){
            if(!(previousBook.equals(soldBooks[i])))
                count=0;
            if(++count>=bestSellerCount){
                bestSellerCount=count;
                bestSeller=soldBooks[i];
            }
        }
        System.out.println(bestSeller);
    }
}
