package bj12018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //과목수
        int m=Integer.parseInt(input[1]); //마일리지
        int needM[]=new int[n]; //필요마일리지
        int count=0;
        for(int i=0; i<n; i++){
            String in[] = br.readLine().split(" ");
            int p=Integer.parseInt(in[0]); //신청한사람
            int l=Integer.parseInt(in[1]); //수강인원
            String mList[] = br.readLine().split(" ");
            int itg[]=new int[mList.length];
            for(int j=0; j<mList.length; j++){
                itg[j]=Integer.parseInt(mList[j]);
            }
            Arrays.sort(itg);
            if(p-l<0)
                needM[i]=1;
            else
                needM[i]=itg[p-l];
        }
        Arrays.sort(needM);
        for(int i=0; i<needM.length; i++){
            m-=needM[i];
            if(m>=0)
                count++;
        }
        System.out.println(count);
    }
}