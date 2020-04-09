package bj18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> dupCheck=new HashSet<>();
        int testCase= Integer.parseInt(br.readLine());
        List<Integer> data=new ArrayList<>();
        Map<Integer, Integer> data2index=new HashMap<>();
        String[] inputStr=br.readLine().split(" ");
        int[] input=new int[testCase];
        for(int i=0; i<testCase; i++){
            input[i]= Integer.parseInt(inputStr[i]);
        }
        for(int i=0; i<testCase; i++){
            if(!dupCheck.contains(input[i])){
                data.add(input[i]);
                dupCheck.add(input[i]);
            }
        }
        Collections.sort(data);
        for(int i=0; i<data.size(); i++){
            data2index.put(data.get(i), i);
        }
        for(int i=0; i<testCase; i++){
            bw.write(data2index.get(input[i])+" ");
        }
        bw.flush();
    }
}