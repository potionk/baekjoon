package bj1543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String target = br.readLine();
        int targetLen = target.length();
        int count = 0;
        int cursor = 0;
        while (document.indexOf(target, cursor) != -1) {
            count++;
            cursor = document.indexOf(target, cursor) + targetLen;
        }
        System.out.println(count);
    }
}