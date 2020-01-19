package bj1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        List<Long> list=new LinkedList<>();
        for(long i=1; i<=46341; i++){
            list.add((i*i));
        }
        long[] data=new long[testCase];
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            data[i]= Long.parseLong(input[1]) - Long.parseLong(input[0]);
        }
        Object[] list2Array=list.toArray();
        for(int i=0; i<data.length; i++){
            if(data[i]==1)
                System.out.println(1);
            else {
                int count=2;
                for(int j=0; j<list2Array.length-1; j++){
                    if(data[i]>(Long)list2Array[j]&&data[i]<=(Long)list2Array[j+1]){
                        if(((Long)list2Array[j+1]+(Long)list2Array[j])/2<data[i]){
                            count++;
                        }
                        System.out.println(count);
                        break;
                    } else {
                        count+=2;
                    }
                }
            }
        }
    }
}