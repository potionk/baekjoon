package bj10816;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> dataMap = new HashMap<>();
        br.readLine();
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            if(dataMap.get(data[i])!=null){
                dataMap.put(data[i],dataMap.get(data[i])+1);
            } else {
                dataMap.put(data[i], 1);
            }
        }
        br.readLine();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (dataMap.get(input[i]) == null)
                bw.write(0 + " ");
            else
                bw.write(dataMap.get(input[i]) + " ");
        }
        bw.flush();
    }
}