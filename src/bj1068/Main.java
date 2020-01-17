package bj1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    static Map<Integer, LinkedList<Integer>> tree = new HashMap<>();
    static int count = 0;
    static int[] testCase;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] testCaseStr = br.readLine().split(" ");
        testCase = new int[testCaseStr.length];
        for (int i = 0; i < testCaseStr.length; i++) {
            testCase[i] = Integer.parseInt(testCaseStr[i]);
        }
        for (int i = 0; i < testCase.length; i++) {
            if (tree.get(testCase[i]) == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                tree.put(testCase[i], list);
            } else {
                LinkedList<Integer> list = tree.get(testCase[i]);
                list.add(i);
                tree.put(testCase[i], list);
            }
        }
        int removeTarget = Integer.parseInt(br.readLine());
        remove(removeTarget);
        System.out.println(count);
    }

    public static void searchTree(int index, int removeTarget) {
        if (!(tree.get(-1).get(0) == index) && tree.get(index) == null)
            count++;
        else {
            if (tree.get(index) != null) {
                LinkedList<Integer> list = tree.get(index);
                Object[] listArray = list.toArray();
                int listLen=listArray.length;
                for (int i = 0; i < listLen; i++) {
                    if ((int) listArray[i] == removeTarget) {
                        if (i == 0&&listLen==1)
                            count++;
                        continue;
                    }
                    searchTree((int) listArray[i], removeTarget);
                }
            }
        }
    }

    public static void remove(int index) {
        tree.remove(index);
        for (int i = 0; i < testCase.length; i++) {
            if (testCase[i] == -1)
                searchTree(i, index);
        }
    }
}
