package bj7587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            Map<String, Data> anagram = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                char[] inputArr = input.toCharArray();
                Arrays.sort(inputArr);
                String sortedInput = new String(inputArr);
                Data data = anagram.getOrDefault(sortedInput, new Data(input, -1, i));
                data.count++;
                anagram.put(sortedInput, data);
            }
            List<Data> dataList = new ArrayList<>(anagram.size());
            for (String s : anagram.keySet()) {
                dataList.add(anagram.get(s));
            }
            dataList.sort(Comparator.comparing(Data::getCount).reversed().thenComparing(Data::getFirstIdx));
            bw.write(dataList.get(0).getOriginal() + " " + dataList.get(0).getCount() + "\n");
        }
        br.close();
        bw.close();
    }
}

class Data {
    String original;
    int count;
    int firstIdx;

    public Data(String original, int count, int firstIdx) {
        this.original = original;
        this.count = count;
        this.firstIdx = firstIdx;
    }

    public String getOriginal() {
        return original;
    }

    public int getCount() {
        return count;
    }

    public int getFirstIdx() {
        return firstIdx;
    }
}
