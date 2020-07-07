package bj11728;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] AStr = br.readLine().split(" ");
        String[] BStr = br.readLine().split(" ");
        int[] arr = new int[AStr.length + BStr.length];
        for (int i = 0; i < AStr.length; i++)
            arr[i] = Integer.parseInt(AStr[i]);
        for (int i = 0; i < BStr.length; i++)
            arr[i + AStr.length] = Integer.parseInt(BStr[i]);
        Arrays.sort(arr);
        for (int value : arr) bw.write(value + " ");
        bw.flush();
    }
}
