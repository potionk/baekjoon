package bj9536;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] data = br.readLine().split(" ");
            String input;
            List<String> list = new ArrayList<>();
            while (!(input = br.readLine()).equals("what does the fox say?")) {
                list.add(input.split(" ")[2]);
            }
            for (String s : data) {
                boolean isOther = false;
                for (String other : list) {
                    if (s.equals(other)) {
                        isOther = true;
                        break;
                    }
                }
                if (!isOther) {
                    System.out.print(s + " ");
                }
            }
        }
    }
}