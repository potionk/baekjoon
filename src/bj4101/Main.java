package bj4101;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc;
        while (!(tc = br.readLine()).equals("0 0")) {
            String[] tcSplit = tc.split(" ");
            if (Integer.parseInt(tcSplit[0]) > Integer.parseInt(tcSplit[1])) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }
        br.close();
        bw.close();
    }
}
