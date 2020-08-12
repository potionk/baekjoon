package bj11557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int univNum = Integer.parseInt(br.readLine());
            Univ[] univs = new Univ[univNum];
            for (int j = 0; j < univNum; j++) {
                String[] univ = br.readLine().split(" ");
                univs[j] = new Univ(univ[0], Integer.parseInt(univ[1]));
            }
            Arrays.sort(univs);
            System.out.println(univs[univNum - 1].getUnivName());
        }
    }
}

class Univ implements Comparable<Univ> {
    String univName;
    int ac; //alcoholConsumption

    public String getUnivName() {
        return univName;
    }

    public int getAc() {
        return ac;
    }

    public Univ(String univName, int ac) {
        this.univName = univName;
        this.ac = ac;
    }

    @Override
    public int compareTo(Univ o) {
        return Integer.compare(this.ac, o.getAc());
    }
}
