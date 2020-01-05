package bj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        Map<String, Integer> data = new HashMap<>();
        String[] soldBooks=new String[num];
        for(int i=0; i<num; i++){
            String input=br.readLine();
            soldBooks[i]=input;
            data.merge(input, 1, Integer::sum);
        }
        Arrays.sort(soldBooks);
        String previousBook="";
        String bestSeller="";
        int bestSellerCount=0;
        for(int i=soldBooks.length-1; i>=0; i--){
            if(previousBook.equals(soldBooks[i]))
                continue;
            if(data.get(soldBooks[i])>=bestSellerCount){
                bestSellerCount=data.get(soldBooks[i]);
                bestSeller=soldBooks[i];
            }
            previousBook=soldBooks[i];
        }
        System.out.println(bestSeller);
    }
}
