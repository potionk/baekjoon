package bj2754;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double grade = 0;
        switch (br.readLine()) {
            case "A+" -> grade = 4.3;
            case "A0" -> grade = 4.0;
            case "A-" -> grade = 3.7;
            case "B+" -> grade = 3.3;
            case "B0" -> grade = 3.0;
            case "B-" -> grade = 2.7;
            case "C+" -> grade = 2.3;
            case "C0" -> grade = 2.0;
            case "C-" -> grade = 1.7;
            case "D+" -> grade = 1.3;
            case "D0" -> grade = 1.0;
            case "D-" -> grade = 0.7;
        }
        bw.write(grade + "");
        br.close();
        bw.close();
    }
}