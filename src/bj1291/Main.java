package bj1291;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] compositeNum = initCompositeNumNum(2701);
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        if (isEMyeonSu(tc)) {
            result++;
        }
        if (isEmHyunSu(tc, compositeNum)) {
            result += 2;
        }
        switch (result) {
            case 0 -> bw.write("3");
            case 1 -> bw.write("1");
            case 2 -> bw.write("2");
            case 3 -> bw.write("4");
        }
        br.close();
        bw.close();
    }

    public static boolean isAbsolute(int i) {
        return i >= 6 || i == 4;
    }

    public static boolean isEMyeonSu(int i) {
        if (!isAbsolute(i)) {
            return false;
        } else {
            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            return sum % 2 == 1;
        }
    }

    public static boolean isChickenNum(int i) {
        return i == 4;
    }

    public static boolean isStarCraftNum(int i) {
        return i == 2;
    }

    public static boolean isEmHyunSu(int i, boolean[] compositeNum) {
        if (isChickenNum(i) || isStarCraftNum(i)) {
            return true;
        }
        if (!compositeNum[i - 1]) {
            return false;
        } else {
            Set<Integer> primeNumSet = new HashSet<>();
            for (int k = 2; i > 1; k++) {
                if (!compositeNum[k - 1]) {
                    while (i % k == 0) {
                        primeNumSet.add(k);
                        i /= k;
                    }
                }
            }
            return primeNumSet.size() % 2 == 0;
        }
    }

    public static boolean[] initCompositeNumNum(int max) {
        boolean[] primeNum = new boolean[max];
        primeNum[0] = false;
        for (int i = 1; i < max; i++) {
            if (!primeNum[i]) {
                for (int j = (i + 1) * 2 - 1; j < max; j += i + 1) {
                    if (!primeNum[j]) {
                        primeNum[j] = true;
                    }
                }
            }
        }
        return primeNum;
    }
}
