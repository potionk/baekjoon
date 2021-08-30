package bj2910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> number = new HashMap<>();
        Map<Integer, Integer> firstAppearance = new HashMap<>();
        String[] NC = br.readLine().split(" ");
        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);
        String[] numStrArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(numStrArr[i]);
            number.merge(n, 1, Integer::sum);
            firstAppearance.putIfAbsent(n, i);
        }
        List<CYNumber> list = new ArrayList<>(number.size());
        for (int i : number.keySet()) {
            list.add(new CYNumber(i, number.get(i), firstAppearance.get(i)));
        }
        list.sort(Comparator.comparing(CYNumber::getCount).reversed().thenComparing(CYNumber::getFirstIdx));
        for (CYNumber cyNumber : list) {
            int count = cyNumber.count;
            while (count-- > 0) {
                bw.write(cyNumber.num + " ");
            }
        }
        br.close();
        bw.close();
    }

    private static class CYNumber {
        int num;
        int count;
        int firstIdx;

        public CYNumber(int num, int count, int firstIdx) {
            this.num = num;
            this.count = count;
            this.firstIdx = firstIdx;
        }

        public int getCount() {
            return count;
        }

        public int getFirstIdx() {
            return firstIdx;
        }
    }
}
