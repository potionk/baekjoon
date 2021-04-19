package bj13751;

import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> plateCom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] bp = br.readLine().split(" ");
        plateCom = new HashSet<>();
        int b = Integer.parseInt(bp[0]);
        int p = Integer.parseInt(bp[1]);
        int[] barbells = new int[b];
        int[] plates = new int[p];
        for (int i = 0; i < b; i++) {
            barbells[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < p; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }
        pushPlate(barbells, plates, 0, 0, 0);
        List<Integer> result = new LinkedList<>(plateCom);
        Collections.sort(result);
        for (int i : result) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }

    public static void pushPlate(int[] barbells, int[] plates, int idx, int left, int right) {
        if (left == right) {
            for (int barbell : barbells) {
                plateCom.add(barbell + left * 2);
            }
        }
        if (idx != plates.length) {
            pushPlate(barbells, plates, idx + 1, left + plates[idx], right);
            pushPlate(barbells, plates, idx + 1, left, right);
            pushPlate(barbells, plates, idx + 1, left, right + plates[idx]);
        }
    }
}
