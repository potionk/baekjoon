package bj5671;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        boolean[] luckyRoom = new boolean[5001];
        boolean[] isVisited = new boolean[5001];
        while ((input = br.readLine()) != null) {
            String[] sf = input.split(" ");
            int start = Integer.parseInt(sf[0]);
            int finish = Integer.parseInt(sf[1]);
            int count = 0;
            for (int i = start; i <= finish; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    if (isLuckyRoom(i)) {
                        luckyRoom[i] = true;
                        count++;
                    }
                } else {
                    if (luckyRoom[i]) {
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }

    static boolean isLuckyRoom(int room) {
        Set<Integer> dupCheck = new HashSet<>();
        while (room > 0) {
            if (dupCheck.contains(room % 10)) {
                return false;
            }
            dupCheck.add(room % 10);
            room /= 10;
        }
        return true;
    }
}
