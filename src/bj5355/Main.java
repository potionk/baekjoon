package bj5355;

import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] tc = br.readLine().split(" ");
            double result = Double.parseDouble(tc[0]);
            for (int i = 1; i < tc.length; i++) {
                switch (tc[i]) {
                    case "@" -> result *= 3;
                    case "%" -> result += 5;
                    case "#" -> result -= 7;
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            bw.write(decimalFormat.format(result) + "\n");
        }
        br.close();
        bw.close();
    }
}
