package bj15920;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        String cmd = br.readLine();
        boolean leverState = false; // false-5명, true-1명
        int location = 0; // 0-A, 1-B, 2-C
        boolean isMultiTrackDrifting = false, isFinish = false;
        for (int i = 0; i < len; i++) {
            if (cmd.charAt(i) == 'P') {
                leverState = !leverState;
                if (location == 1) {
                    isMultiTrackDrifting = true;
                }
            } else {
                location++;
            }
            if (location == 2) {
                if (isMultiTrackDrifting) {
                    bw.write("6");
                } else {
                    if (leverState) {
                        bw.write("1");
                    } else {
                        bw.write("5");
                    }
                }
                isFinish = true;
                break;
            }
        }
        if (!isFinish) {
            bw.write('0');
        }
        br.close();
        bw.close();
    }
}