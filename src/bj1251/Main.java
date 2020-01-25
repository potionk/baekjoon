package bj1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static char[] testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<String> splitedData=new ArrayList<>();
        StringBuilder sb;
        testCase=br.readLine().toCharArray();
        for(int i=1; i<testCase.length-1; i++){
            for(int j=i+1; j<testCase.length; j++){
                sb=new StringBuilder();
                sb.append(reverseChar(0,i-1));
                sb.append(reverseChar(i,j-1));
                sb.append(reverseChar(j,testCase.length-1));
                splitedData.add(sb.toString());
            }
        }
        Collections.sort(splitedData);
        System.out.println(splitedData.get(0));
    }
    public static String reverseChar(int start, int finish){
        char[] output=new char[finish-start+1];
        for(int i=finish, outputIndex=0; i>=start; i--, outputIndex++){
            output[outputIndex]=testCase[i];
        }
        return new String(output);
    }
}