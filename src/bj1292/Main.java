package bj1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] data=new int[1001];
        int idx=1;
        int dataIdx=1;
        while(dataIdx<1001){
            for(int i=0; i<idx; i++){
                if(dataIdx>=1001)
                    break;
                data[dataIdx++]=idx;
            }
            idx++;
        }
        String[] tc=br.readLine().split(" ");
        int start= Integer.parseInt(tc[0]);
        int finish= Integer.parseInt(tc[1]);
        int total=0;
        for(int i=start; i<=finish; i++){
            total+=data[i];
        }
        System.out.println(total);
    }
}
