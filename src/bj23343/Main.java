package bj23343;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] xy = br.readLine().split(" ");
        if (isNum(xy[0]) && isNum(xy[1])) {
            bw.write(Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]) + "");
        } else {
            bw.write("NaN");
        }
        br.close();
        bw.close();
    }

    private static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}