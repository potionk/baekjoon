package bj1920;

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
            dataMap.put(data[i], 1);
        }
        br.readLine();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (dataMap.get(input[i]) != null)
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }
        bw.flush();
    }
}