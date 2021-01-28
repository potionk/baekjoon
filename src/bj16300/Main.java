package bj16300;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ingr = br.readLine().split(" ");
        String target = br.readLine();
        Pattern pattern = Pattern.compile("\\D|\\d+");
        int[] bag = analyze(ingr[0], pattern);
        for (int i = 0; i < 26; i++) {
            bag[i] *= Integer.parseInt(ingr[1]);
        }
        int[] targetBag = analyze(target, pattern);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (targetBag[i] > 0) {
                min = Math.min(min, bag[i] / targetBag[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        bw.write(min + "");
        br.close();
        bw.close();
    }

    public static int[] analyze(String target, Pattern pattern) {
        Matcher matcher = pattern.matcher(target);
        List<String> ingrList = new ArrayList<>();
        int[] result = new int[26];
        while (matcher.find()) {
            ingrList.add(matcher.group());
        }
        int size = ingrList.size();
        for (int i = 0; i < size; i++) {
            String s = ingrList.get(i);
            int num = 1;
            if (i + 1 < size) {
                if (isNum(ingrList.get(i + 1))) {
                    num = Integer.parseInt(ingrList.get(i + 1));
                    i++;
                }
            }
            int sLen = s.length();
            for (int j = 0; j < sLen; j++) {
                result[s.charAt(j) - 'A'] += num;
            }
        }
        return result;
    }

    public static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
