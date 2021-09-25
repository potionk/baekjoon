package bj19591;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        String[] arr = new String[1000001];
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : tc) {
            if (!isNum(c)) {
                arr[idx++] = sb.toString();
                sb = new StringBuilder();
                arr[idx++] = c + "";
            } else {
                sb.append(c);
            }
        }
        arr[idx++] = sb.toString();
        int start = 0, end = idx;
        if (arr[0].equals("")) {
            arr[2] = "-" + arr[2];
            start = 2;
        }
        while (start < end) {
            int size = end - start;
            if (size == 1) {
                break;
            }
            if (size > 3) {
                int leftPriority = getPriority(arr[start + 1]);
                int rightPriority = getPriority(arr[end - 2]);
                if (leftPriority < rightPriority) {
                    arr[end - 3] = calExp(arr[end - 3], arr[end - 2], arr[end - 1]) + "";
                    end -= 2;
                } else if (leftPriority > rightPriority) {
                    arr[start + 2] = calExp(arr[start], arr[start + 1], arr[start + 2]) + "";
                    start += 2;
                } else {
                    long leftResult = calExp(arr[start], arr[start + 1], arr[start + 2]);
                    long rightResult = calExp(arr[end - 3], arr[end - 2], arr[end - 1]);
                    if (leftResult < rightResult) {
                        arr[end - 3] = rightResult + "";
                        end -= 2;
                    } else {
                        arr[start + 2] = leftResult + "";
                        start += 2;
                    }
                }
            } else {
                arr[start + 2] = calExp(arr[start], arr[start + 1], arr[start + 2]) + "";
                start += 2;
                break;
            }
        }
        bw.write(Long.parseLong(arr[start]) + "");
        bw.close();
        br.close();
    }

    public static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public static int getPriority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    public static long calExp(String a, String operator, String b) {
        long x = Long.parseLong(a);
        long y = Long.parseLong(b);
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> -1;
        };
    }
}