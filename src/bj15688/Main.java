package bj15688;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Integer::compare);
        for (int i : list) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }
}
