package bj5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new ArrayList<>();
        String input;
        while((input=br.readLine())!=null&&!input.equals("")){
            list.add(Integer.parseInt(input));
        }
        Object[] list2Array=list.toArray();
        testCase=new int[list2Array.length];
        for(int i=0; i<list2Array.length; i++){
            testCase[i]=(int)list2Array[i];
        }
        pre2post(0, testCase.length-1);
    }
    public static void pre2post(int startIndex, int endIndex){
        if(startIndex==endIndex){
            System.out.println(testCase[startIndex]);
            return;
        } else if(startIndex>endIndex)
            return;
        int nextEndIndex=startIndex;
        while(nextEndIndex+1<testCase.length&&testCase[startIndex]>testCase[++nextEndIndex]);
        pre2post(startIndex+1,nextEndIndex-1);
        pre2post(nextEndIndex,endIndex);
        System.out.println(testCase[startIndex]);
    }
}