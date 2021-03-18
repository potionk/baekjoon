package bj1871;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] carNumber = br.readLine().split("-");
            if (Math.abs(cal26System(carNumber[0]) - Integer.parseInt(carNumber[1])) <= 100) {
                bw.write("nice\n");
            } else {
                bw.write("not nice\n");
            }
        }
        br.close();
        bw.close();
    }

    public static int cal26System(String LLL) {
        int result = 0;
        for (int i = 2; i >= 0; i--) {
            result += (LLL.charAt(2 - i) - 'A') * Math.pow(26, i);
        }
        return result;
    }
}
