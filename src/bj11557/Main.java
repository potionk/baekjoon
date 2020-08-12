package bj11557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int min = Integer.parseInt(tc[0]);
        int max = Integer.parseInt(tc[1]);
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Data[] data = new Data[max - min + 1];
        for (int i = min; i <= max; i++) {
            if (i < 10) {
                data[i - min] = new Data(i, num[i]);
            } else {
                data[i - min] = new Data(i, num[i / 10] + " " + num[i % 10]);
            }
        }
        Arrays.sort(data);
        for (int i = 0; i < max - min + 1; i++) {
            System.out.print(data[i].getNum() + " ");
            if (i % 10 == 9)
                System.out.println();
        }

    }
}

class Data implements Comparable<Data> {
    int num;
    String numStr;

    public int getNum() {
        return num;
    }

    public String getNumStr() {
        return numStr;
    }

    public Data(int num, String numStr) {
        this.num = num;
        this.numStr = numStr;
    }


    @Override
    public int compareTo(Data o) {
        return this.numStr.compareTo(o.getNumStr());
    }
}
