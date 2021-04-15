package bj17479;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ABC = br.readLine().split(" ");
        int A = Integer.parseInt(ABC[0]);
        int B = Integer.parseInt(ABC[1]);
        int C = Integer.parseInt(ABC[2]);
        Map<String, Integer> normalMenu = new HashMap<>();
        Map<String, Integer> specialMenu = new HashMap<>();
        Set<String> serviceMenu = new HashSet<>();
        Map<String, String> menu = new HashMap<>();
        for (int i = 0; i < A; i++) {
            String[] line = br.readLine().split(" ");
            normalMenu.put(line[0], Integer.parseInt(line[1]));
            menu.put(line[0], "normal");
        }
        for (int i = 0; i < B; i++) {
            String[] line = br.readLine().split(" ");
            specialMenu.put(line[0], Integer.parseInt(line[1]));
            menu.put(line[0], "special");
        }
        for (int i = 0; i < C; i++) {
            String line = br.readLine();
            serviceMenu.add(line);
            menu.put(line, "service");
        }
        int N = Integer.parseInt(br.readLine());
        long normalTotalPrice = 0, specialTotalPrice = 0, serviceMenuCount = 0;
        for (int i = 0; i < N; i++) {
            String order = br.readLine();
            switch (menu.get(order)) {
                case "normal" -> normalTotalPrice += (long) normalMenu.get(order);
                case "special" -> specialTotalPrice += (long) specialMenu.get(order);
                case "service" -> serviceMenuCount++;
            }
        }
        if (specialTotalPrice > 0) {
            if (normalTotalPrice < 20000 || serviceMenuCount > 1 || (serviceMenuCount == 1 && normalTotalPrice + specialTotalPrice < 50000)) {
                bw.write("No");
            } else {
                bw.write("Okay");
            }
        } else if (serviceMenuCount > 1 || (serviceMenuCount == 1 && normalTotalPrice < 50000)) {
            bw.write("No");
        } else {
            bw.write("Okay");
        }
        br.close();
        bw.close();
    }
}
