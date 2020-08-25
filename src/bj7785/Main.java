package bj7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> isEnter = new HashSet<>();
        Set<String> dupCheck = new HashSet<>();
        List<String> list = new ArrayList<>();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            if (input[1].equals("enter")) {
                if (!dupCheck.contains(input[0])) {
                    list.add(input[0]);
                }
                dupCheck.add(input[0]);
                isEnter.add(input[0]);
            } else {
                isEnter.remove(input[0]);
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            String target = list.get(i);
            if (isEnter.contains(target)) {
                bw.write(target + "\n");
            }
        }
        bw.flush();
    }
}