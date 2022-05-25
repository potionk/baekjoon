package bj4828;

import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc;
        while ((tc = br.readLine()) != null) {
            if (isValid(tc)) {
                bw.write("valid\n");
            } else {
                bw.write("invalid\n");
            }
        }
        br.close();
        bw.close();
    }

    public static boolean isValid(String s) {
        Pattern tagPattern = Pattern.compile("</*[a-z|0-9]+/*>");
        Matcher matcher = tagPattern.matcher(s);
        if (!isTagValid(matcher)) {
            return false;
        }
        int startIdx = 0, finishIdx = s.length();
        Pattern escapeSqPattern = Pattern.compile("&(lt|gt|amp|x[0-9|A-F|a-f]*);");
        matcher = tagPattern.matcher(s);
        while (matcher.find()) {
            int matchStartIdx = matcher.start();
            String target = s.substring(startIdx, matchStartIdx);
            if (!isPlainTextValid(target, escapeSqPattern.matcher(target))) {
                return false;
            }
            startIdx = matcher.end();
        }
        String target = s.substring(startIdx, finishIdx);
        return isPlainTextValid(target, escapeSqPattern.matcher(target));
    }

    public static boolean isPlainTextValid(String s, Matcher matcher) {
        int len = s.length();
        int ampersandCount = 0;
        int escapeSqCount = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!(32 <= c && c <= 127 && c != '<' && c != '>')) {
                return false;
            }
            if (c == '&') {
                ampersandCount++;
            }
        }
        while (matcher.find()) {
            String g = matcher.group();
            if (g.charAt(1) == 'x') {
                int gLen = g.length();
                gLen -= 3;
                if (gLen % 2 == 1 || gLen == 0) {
                    return false;
                }
            }
            escapeSqCount++;
        }
        return ampersandCount == escapeSqCount;
    }

    public static boolean isTagValid(Matcher matcher) {
        Stack<String> stack = new Stack<>();
        while (matcher.find()) {
            String find = matcher.group();
            boolean isNotPushTag = find.charAt(find.length() - 2) != '/';
            if (find.charAt(1) != '/') { // 여는 태그
                if (isNotPushTag) {
                    stack.push(find);
                }
            } else { // 닫는 태그
                if (!stack.isEmpty() && isNotPushTag) {
                    String peek = stack.peek();
                    if (find.substring(2, find.length() - 1).equals(peek.substring(1, peek.length() - 1))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
