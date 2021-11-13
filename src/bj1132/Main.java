package bj1132;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordNum = Integer.parseInt(br.readLine());
        Data[] count = new Data[10];
        for (int i = 0; i < 10; i++) {
            count[i] = new Data(0);
        }
        while (wordNum-- > 0) {
            String word = br.readLine();
            int wordLen = word.length();
            count[word.charAt(0) - 'A'].first = true;
            long mul = 1;
            for (int i = wordLen - 1; i >= 0; i--, mul *= 10) {
                count[word.charAt(i) - 'A'].value += mul;
            }
        }
        Arrays.sort(count);
        int findIdx = 0;
        for (int c = 0; c < 9; c++) {
            if (count[c].first) {
                findIdx++;
            } else {
                break;
            }
        }
        for (int c = findIdx; c > 0; c--) {
            Data temp = count[c];
            count[c] = count[c - 1];
            count[c - 1] = temp;
        }
        long result = 0;
        for (int c = 9; c >= 0; c--) {
            result += count[c].value * c;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    private static class Data implements Comparable<Data> {
        boolean first;
        long value;

        public Data(long value) {
            this.value = value;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.value, o.value);
        }
    }
}
