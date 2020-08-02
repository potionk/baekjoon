package bj1235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] inputs = new String[tc];
        for (int i = 0; i < tc; i++) {
            inputs[i] = br.readLine();
        }
        int num = 1;
        int size = inputs[0].length();
        while (num != size) {
            boolean isFinish = false;
            for (int i = 0; i < tc; i++) {
                String check = inputs[i].substring(size - num, size);
                if (map.get(check) == null) {
                    map.put(check, 1);
                } else {
                    isFinish = true;
                    break;
                }
            }
            if (isFinish) {
                num++;
            } else {
                break;
            }
        }
        System.out.println(num);
    }
}
