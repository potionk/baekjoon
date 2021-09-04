package bj2755;

import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int totalCredit = 0;
        double totalGrade = 0;
        while (N-- > 0) {
            String[] gradeInfo = br.readLine().split(" ");
            int credit = Integer.parseInt(gradeInfo[1]);
            int grade = 0;
            switch (gradeInfo[2]) {
                case "A+" -> grade = 43;
                case "A0" -> grade = 40;
                case "A-" -> grade = 37;
                case "B+" -> grade = 33;
                case "B0" -> grade = 30;
                case "B-" -> grade = 27;
                case "C+" -> grade = 23;
                case "C0" -> grade = 20;
                case "C-" -> grade = 17;
                case "D+" -> grade = 13;
                case "D0" -> grade = 10;
                case "D-" -> grade = 7;
            }
            totalCredit += credit;
            totalGrade += grade * credit;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        bw.write(decimalFormat.format(Math.round(totalGrade / totalCredit * 10) / 100.0) + "");
        br.close();
        bw.close();
    }
}
