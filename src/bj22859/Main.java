package bj22859;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String html = br.readLine();
        Pattern tagPattern = Pattern.compile("</*[a-z|0-9]+\\s*>|<div[a-z|A-z|_|\\s|\"|=\\d]+>");
        Matcher matcher = tagPattern.matcher(html);
        int beforeEndIdx = 0;
        List<String> list = new LinkedList<>();
        while (matcher.find()) {
            int matchStartIdx = matcher.start();
            if (matchStartIdx != beforeEndIdx) {
                list.add(html.substring(beforeEndIdx, matchStartIdx));
            }
            beforeEndIdx = matcher.end();
            list.add(matcher.group());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (s.startsWith("<")) {
                if (s.startsWith("<div ")) {
                    String info = getDivTagInfo(s);
                    if (info != null) {
                        bw.write(getDivTagInfo(s) + "\n");
                    }
                } else if (s.startsWith("</p>")) {
                    bw.write(sb.toString().trim().replaceAll("\\s+", " ") + "\n");
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s);
            }
        }
        br.close();
        bw.close();
    }

    public static String getDivTagInfo(String s) {
        String[] split = s.split("\"");
        if (split.length > 1) {
            return "title : " + split[1];
        } else {
            return null;
        }
    }
}
