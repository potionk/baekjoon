package bj5076;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc;
        Pattern tagPattern = Pattern.compile("(<([^>]+)>)");
        while (!(tc = br.readLine()).equals("#")) {
            Matcher matcher = tagPattern.matcher(tc);
            Stack<String> stack = new Stack<>();
            boolean legal = true;
            while (matcher.find()) {
                String tag = matcher.group();
                if (tag.startsWith("</")) {
                    if (!stack.isEmpty()) {
                        String[] tagName = stack.peek().split(" ");
                        if (tagName.length > 1) {
                            tagName[0] += ">";
                        }
                        if (tagName[0].substring(1).equals(tag.substring(2))) {
                            stack.pop();
                        }
                    } else {
                        legal = false;
                        break;
                    }
                } else {
                    if (!tag.endsWith("/>")) {
                        stack.push(tag);
                    }
                }
            }
            if (legal && stack.isEmpty()) {
                bw.write("legal\n");
            } else {
                bw.write("illegal\n");
            }
        }
        br.close();
        bw.close();
    }
}
