package bj11536;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String[] list = new String[T];
        for (int i = 0; i < T; i++) {
            list[i] = br.readLine();
        }
        String[] listCopy = Arrays.copyOf(list, list.length);
        Arrays.sort(listCopy);
        boolean equal = true;
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals(listCopy[i])) {
                equal = false;
                break;
            }
        }
        if (equal) {
            bw.write("INCREASING");
            bw.close();
            br.close();
            return;
        } else {
            equal = true;
            Arrays.sort(listCopy, Collections.reverseOrder());
            for (int i = 0; i < list.length; i++) {
                if (!list[i].equals(listCopy[i])) {
                    equal = false;
                    break;
                }
            }
        }
        if (equal) {
            bw.write("DECREASING");
        } else {
            bw.write("NEITHER");
        }
        br.close();
        bw.close();
    }
}
