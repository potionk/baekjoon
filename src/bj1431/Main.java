package bj1431;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        SerialNum[] serialNums = new SerialNum[num];
        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            int total = 0;
            for (int j = 0; j < input.length(); j++) {
                if (48 <= input.charAt(j) && input.charAt(j) <= 57) {
                    total += input.charAt(j) - '0';
                }
            }
            serialNums[i] = new SerialNum(input, total);
        }
        Arrays.sort(serialNums);
        for (int i = 0; i < num; i++) {
            bw.write(serialNums[i].getSerial() + "\n");
        }
        bw.flush();
    }
}

class SerialNum implements Comparable<SerialNum> {
    String serial;
    int total;

    public SerialNum(String serial, int total) {
        this.serial = serial;
        this.total = total;
    }

    public String getSerial() {
        return serial;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public int compareTo(SerialNum o) {
        if (this.serial.length() < o.getSerial().length()) {
            return -1;
        } else if (this.serial.length() == o.getSerial().length()) {
            if (this.total < o.getTotal()) {
                return -1;
            } else if (this.total == o.getTotal()) {
                return this.serial.compareTo(o.getSerial());
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}