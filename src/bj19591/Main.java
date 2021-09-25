package bj19591;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : tc) {
            if (!isNum(c)) {
                list.add(sb.toString());
                sb = new StringBuilder();
                list.add(c + "");
            } else {
                sb.append(c);
            }
        }
        list.add(sb.toString());
        int start = 0, end = list.size();
        if (list.get(0).equals("")) {
            list.set(2, "-" + list.get(2));
            start = 2;
        }
        while (start < end) {
            int size = end - start;
            if (size == 1) {
                break;
            }
            if (size > 3) {
                int leftPriority = getPriority(list.get(start + 1));
                int rightPriority = getPriority(list.get(end - 2));
                if (leftPriority < rightPriority) {
                    list.set(end - 3, calExp(list.get(end - 3), list.get(end - 2), list.get(end - 1)) + "");
                    end -= 2;
                } else if (leftPriority > rightPriority) {
                    list.set(start + 2, calExp(list.get(start), list.get(start + 1), list.get(start + 2)) + "");
                    start += 2;
                } else {
                    long leftResult = calExp(list.get(start), list.get(start + 1), list.get(start + 2));
                    long rightResult = calExp(list.get(end - 3), list.get(end - 2), list.get(end - 1));
                    if (leftResult < rightResult) {
                        list.set(end - 3, rightResult + "");
                        end -= 2;
                    } else {
                        list.set(start + 2, leftResult + "");
                        start += 2;
                    }
                }
            } else {
                list.set(start + 2, calExp(list.get(start), list.get(start + 1), list.get(start + 2)) + "");
                start += 2;
                break;
            }
        }
        bw.write(Long.parseLong(list.get(start)) + "");
        bw.close();
        br.close();
    }

    public static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public static int getPriority(String operator) {
        switch (operator) {
            case "+", "-" -> {
                return 1;
            }
            case "*", "/" -> {
                return 2;
            }
        }
        return -1;
    }

    public static long calExp(String a, String operator, String b) {
        long x = Long.parseLong(a);
        long y = Long.parseLong(b);
        switch (operator) {
            case "+" -> {
                return x + y;
            }
            case "-" -> {
                return x - y;
            }
            case "*" -> {
                return x * y;
            }
            case "/" -> {
                return x / y;
            }
        }
        return -1;
    }
}