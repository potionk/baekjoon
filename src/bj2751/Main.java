package bj2751;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        Object[] list2Array = list.toArray();
        for (int i = 0; i < size; i++) {
            bw.write(list2Array[i] + "\n");
        }
        br.close();
        bw.close();
    }
}