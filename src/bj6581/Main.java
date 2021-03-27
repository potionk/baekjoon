package bj6581;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            String[] inputSplitted = input.split("[ \t]");
            for (String s : inputSplitted) {
                switch (s) {
                    case "<br>" -> {
                        bw.write(sb.toString() + "\n");
                        sb = new StringBuilder();
                    }
                    case "<hr>" -> {
                        if (!sb.isEmpty()) {
                            bw.write(sb.toString() + "\n");
                        }
                        bw.write("--------------------------------------------------------------------------------\n");
                        sb = new StringBuilder();
                    }
                    default -> {
                        if (!s.isBlank()) {
                            if (sb.toString().length() == 0) {
                                sb.append(s);
                            } else if (sb.toString().length() + s.length() + 1 <= 80) {
                                sb.append(" ").append(s);
                            } else {
                                bw.write(sb.toString() + "\n");
                                sb = new StringBuilder();
                                sb.append(s);
                            }
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}