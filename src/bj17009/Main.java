package bj17009;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int aTeamScore = 0, bTeamScore = 0;
        for (int i = 3; i >= 1; i--) {
            aTeamScore += i * Integer.parseInt(br.readLine());
        }
        for (int i = 3; i >= 1; i--) {
            bTeamScore += i * Integer.parseInt(br.readLine());
        }
        if (aTeamScore > bTeamScore) {
            bw.write("A");
        } else if (aTeamScore < bTeamScore) {
            bw.write("B");
        } else {
            bw.write("T");
        }
        br.close();
        bw.close();
    }
}
