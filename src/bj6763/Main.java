package bj6763;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int limit = Integer.parseInt(br.readLine());
        int recorded = Integer.parseInt(br.readLine());
        int diff = recorded - limit;
        if (diff <= 0) {
            bw.write("Congratulations, you are within the speed limit!");
        } else if (diff <= 20) {
            bw.write("You are speeding and your fine is $100.");
        } else if (diff <= 30) {
            bw.write("You are speeding and your fine is $270.");
        } else {
            bw.write("You are speeding and your fine is $500.");
        }
        br.close();
        bw.close();
    }
}
