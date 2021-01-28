package bj2757;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String RnCm = br.readLine();
            if (RnCm.equals("R0C0")) {
                break;
            }
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(RnCm);
            matcher.find();
            int row = Integer.parseInt(matcher.group()); // result num
            matcher.find();
            int column = Integer.parseInt(matcher.group());
            bw.write(column2ExcelAlpha(column) + row + "\n");
        }
        br.close();
        bw.close();
    }

    public static String column2ExcelAlpha(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.insert(0, (char) ('A' + (--i) % 26));
            i /= 26;
        }
        return sb.toString();
    }
}
