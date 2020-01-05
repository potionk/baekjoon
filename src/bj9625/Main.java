package bj9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int aNum=1;
        int bNum=0;
        for(int i=0; i<num; i++){
            int tempAnum=bNum;
            bNum+=aNum;
            aNum=tempAnum;
        }
        System.out.println(aNum+" "+bNum);
    }
}
