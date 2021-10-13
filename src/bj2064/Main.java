package bj2064;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] ip = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split("\\.");
            for (int j = 0; j < 4; j++) {
                ip[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] networkAddress = new int[4];
        for (int j = 0; j < 4; j++) {
            int result = 255;
            for (int i = 0; i < n; i++) {
                result &= ip[i][j];
            }
            networkAddress[j] = result;
            sb.append(Integer.toBinaryString(result));
        }
        System.out.println(sb.toString());
        if (sb.length() < 32) {
            sb.insert(0, "0".repeat(32 - sb.length()));
        }
        int targetIdx = 0;
        for (int i = 31; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                targetIdx = i;
                break;
            }
        }
        char[] subnetMaskBit = new char[32];
        for (int i = 0; i < 32; i++) {
            subnetMaskBit[i] = '1';
        }
        int m = 32;
        int[] result = new int[4];
        int networkAddressIdx = targetIdx / 8;
        int networkAddressBitIdx = targetIdx % 8;
        while (m != 0) {
            if (m != 32) {
                subnetMaskBit[m] = '0';
            }
            int[] subnetMask = new int[4];
            for (int i = 0; i < 32; i += 8) {
                subnetMask[i / 8] = Integer.parseInt(new String(subnetMaskBit, i, 8), 2);
            }
            boolean available = true;
            for (int i = 0; i < n; i++) {
                if (!available) {
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    if ((ip[i][j] & subnetMask[j]) != networkAddress[j]) {
                        available = false;
                        break;
                    }
                }
            }
            if (available) {
                result = subnetMask;
                break;
            }
            m--;
            if (m <= targetIdx) {
                networkAddress[networkAddressIdx] &= Integer.parseInt("1".repeat(networkAddressBitIdx) + "0".repeat(8 - networkAddressBitIdx), 2);
                if (networkAddressBitIdx == 0) {
                    networkAddressBitIdx = 7;
                    networkAddressIdx--;
                    if (networkAddressIdx < 0) {
                        break;
                    }
                } else {
                    networkAddressBitIdx--;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                bw.write(networkAddress[i] + ".");
            } else {
                bw.write(networkAddress[i] + "\n");
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                bw.write(result[i] + ".");
            } else {
                bw.write(result[i] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
