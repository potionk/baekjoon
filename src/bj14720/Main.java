package bj14720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int mode = 0;
        br.readLine();
        String[] milkShop = br.readLine().split(" ");
        int result = 0;
        for (String s : milkShop) {
            if (s.equals(String.valueOf(mode))) {
                mode++;
                mode %= 3;
                result++;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
