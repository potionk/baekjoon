package bj1181;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, LinkedList<String>> classifyByLen=new HashMap<>();
        Map<String,Integer> dupCheck=new HashMap<>();
        int num=Integer.parseInt(br.readLine());
        String input;
        for(int i=0; i<num; i++){
            input=br.readLine();
            if(dupCheck.get(input)==null){
                if(classifyByLen.get(input.length())==null){
                    LinkedList<String> data=new LinkedList<>();
                    data.add(input);
                    classifyByLen.put(input.length(),data);
                } else {
                    LinkedList<String> data=classifyByLen.get(input.length());
                    data.add(input);
                    classifyByLen.put(input.length(),data);
                }
            }
            dupCheck.put(input,1);
        }
        for(int i=1; i<=50; i++){
            LinkedList<String> list=classifyByLen.get(i);
            if(list==null)
                continue;
            String[] list2Array= list.toArray(new String[0]);
            Arrays.sort(list2Array);
            for(int j=0; j<list2Array.length; j++){
                bw.write(list2Array[j]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}