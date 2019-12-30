package bj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String card[] = br.readLine().split(" ");
        String input[] = br.readLine().split(" ");
        int cards=Integer.parseInt(card[0]);
        int M=Integer.parseInt(card[1]);
        int sub=Integer.MAX_VALUE;
        int cardArray[]=new int[input.length];
        int total=0;
        int flag=0;
        for(int i=0; i<cardArray.length; i++){
            cardArray[i]=Integer.parseInt(input[i]);
        }
        for(int i=0; i<cards-2; i++){
            if(flag==0) {
                for (int j = i+1; j < cards - 1; j++) {
                    if(flag==0) {
                        for (int k = j+1; k < cards; k++) {
                            total = cardArray[i] + cardArray[j] + cardArray[k];
                            if (total == M){
                                sub=0;
                                flag=1;
                                break;
                            }
                            else if (M-total>0 && M-total < sub)
                                sub = M-total;
                        }
                    }
                }
            }
        }
        System.out.println(M-sub);
    }
}