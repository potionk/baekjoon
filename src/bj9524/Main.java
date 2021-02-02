package bj9524;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] yekaterinburg = {1, 7, 2, 3};
        bw.write(yekaterinburg[Integer.parseInt(br.readLine()) - 1]+"");
        br.close();
        bw.close();
    }
}