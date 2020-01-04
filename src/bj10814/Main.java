package bj10814;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, LinkedList<String>> classifyByAge = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        String[] input;
        int age;
        String name;
        for (int i = 0; i < num; i++) {
            input = br.readLine().split(" ");
            age = Integer.parseInt(input[0]);
            name = input[1];
            if (classifyByAge.get(age) == null) {
                LinkedList<String> data = new LinkedList<>();
                data.add(name);
                classifyByAge.put(age, data);
            } else {
                LinkedList<String> data = classifyByAge.get(age);
                data.add(name);
                classifyByAge.put(age, data);
            }
        }
        for (int i = 1; i <= 200; i++) {
            LinkedList<String> list = classifyByAge.get(i);
            if (list == null)
                continue;
            String[] list2Array = list.toArray(new String[0]);
            for (int j = 0; j < list2Array.length; j++) {
                bw.write(i+" "+list2Array[j] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}