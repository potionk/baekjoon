package bj15610;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigDecimal area = new BigDecimal(br.readLine());
        BigDecimal d = area.sqrt(MathContext.DECIMAL64);
        bw.write((d.multiply(new BigDecimal(4))) + "");
        br.close();
        bw.close();
    }
}
