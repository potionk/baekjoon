package bj11005;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        ArrayList<Character> list = new ArrayList<>();
        int N = Integer.parseInt(tc[0]);
        int j = Integer.parseInt(tc[1]);
        int thisN = N;
        while (thisN > 0) {
            list.add(toNbase(thisN % j));
            thisN /= j;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i));
        }
        bw.flush();
    }

    public static char toNbase(int i) {
        if (i < 10) {
            return (char) (i + '0');
        } else {
            return (char) (i + 55);
        }
    }
}