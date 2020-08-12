package bj10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] tc = br.readLine().split(" ");
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            int t = Integer.parseInt(tc[i]);
            if (map.get(t) == null) {
                map.put(Integer.parseInt(tc[i]), 1);
                list.add(t);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
