package bj11931;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        while (N-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Collections.reverseOrder());
        for (int i : list) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }
}
