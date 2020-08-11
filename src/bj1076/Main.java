package bj1076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first=br.readLine();
        String second=br.readLine();
        String third=br.readLine();
        Map<String, String> fs = new HashMap<String, String>() {{
            put("black", "0");
            put("brown", "1");
            put("red", "2");
            put("orange", "3");
            put("yellow", "4");
            put("green", "5");
            put("blue", "6");
            put("violet", "7");
            put("grey", "8");
            put("white", "9");
        }};
        Map<String, Long> mul = new HashMap<String, Long>() {{
            put("black", 1L);
            put("brown", 10L);
            put("red", 100L);
            put("orange", 1000L);
            put("yellow", 10000L);
            put("green", 100000L);
            put("blue", 1000000L);
            put("violet", 10000000L);
            put("grey", 100000000L);
            put("white", 1000000000L);
        }};
        String t=fs.get(first)+fs.get(second);
        System.out.println(Long.parseLong(t)*mul.get(third));
    }
}
