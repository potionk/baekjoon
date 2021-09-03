package bj2290;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int s = Integer.parseInt(info[0]);
        char[] n = info[1].toCharArray();
        for (char c : n) {
            switch (c) {
                case '0', '2', '3', '5', '6', '7', '8', '9' -> bw.write(" " + repeatChar('-', s) + " ");
                case '1', '4' -> bw.write(repeatChar(' ', s + 2));
            }
            bw.write(" ");
        }
        bw.write("\n");
        for (int i = 0; i < s; i++) {
            for (char c : n) {
                switch (c) {
                    case '1', '2', '3', '7' -> bw.write(repeatChar(' ', s + 1) + '|');
                    case '4', '8', '9', '0' -> bw.write('|' + repeatChar(' ', s) + '|');
                    case '5', '6' -> bw.write('|' + repeatChar(' ', s + 1));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        for (char c : n) {
            switch (c) {
                case '2', '3', '4', '5', '6', '8', '9' -> bw.write(" " + repeatChar('-', s) + " ");
                case '1', '7', '0' -> bw.write(repeatChar(' ', s + 2));
            }
            bw.write(" ");
        }
        bw.write("\n");
        for (int i = 0; i < s; i++) {
            for (char c : n) {
                switch (c) {
                    case '1', '3', '4', '5', '7', '9' -> bw.write(repeatChar(' ', s + 1) + '|');
                    case '6', '8', '0' -> bw.write('|' + repeatChar(' ', s) + '|');
                    case '2' -> bw.write('|' + repeatChar(' ', s + 1));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        for (char c : n) {
            switch (c) {
                case '2', '3', '5', '6', '8', '9', '0' -> bw.write(" " + repeatChar('-', s) + " ");
                case '1', '4', '7' -> bw.write(repeatChar(' ', s + 2));
            }
            bw.write(" ");
        }
        br.close();
        bw.close();
    }

    public static String repeatChar(char c, int num) {
        StringBuilder sb = new StringBuilder();
        while (num-- > 0) {
            sb.append(c);
        }
        return sb.toString();
    }
}
