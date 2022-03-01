package bj5635;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        List<StudentInfo> studentInfoList = new ArrayList<>(T);
        for (int i = 0; i < T; i++) {
            String[] info = br.readLine().split(" ");
            studentInfoList.add(new StudentInfo(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }
        studentInfoList.sort(Comparator.comparing(StudentInfo::getYear).thenComparing(StudentInfo::getMonth).thenComparing(StudentInfo::getDay));
        bw.write(studentInfoList.get(T - 1).getName() + "\n" + studentInfoList.get(0).getName());
        br.close();
        bw.close();
    }

    private static class StudentInfo {
        String name;
        int day;
        int month;
        int year;

        public StudentInfo(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }
    }
}
