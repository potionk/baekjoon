package bj13414;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] KL = br.readLine().split(" ");
        int k = Integer.parseInt(KL[0]);
        int l = Integer.parseInt(KL[1]);
        Map<String, Integer> dupCheck = new HashMap<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            String readline = br.readLine();
            dupCheck.put(readline, i);
            list.add(readline);
        }
        int i = 0, count = 0;
        for (String s : list) {
            if (dupCheck.get(s) == i) {
                bw.write(s + "\n");
                count++;
            }
            if (count == k) {
                break;
            }
            i++;
        }
        br.close();
        bw.close();
    }
}
