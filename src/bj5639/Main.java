package bj5639;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new LinkedList<>();
        String input;
        while ((input = br.readLine()) != null) {
            list.add(Integer.parseInt(input));
        }
        int[] preorder = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            preorder[idx++] = i;
        }
        pre2post(0, preorder.length - 1, preorder, bw);
        br.close();
        bw.close();
    }

    public static void pre2post(int startIndex, int endIndex, int[] preorder, BufferedWriter bw) throws IOException {
        if (startIndex > endIndex)
            return;
        int nextEndIndex = startIndex + 1;

        while (nextEndIndex < preorder.length && preorder[startIndex] > preorder[nextEndIndex])
            nextEndIndex++;
        pre2post(startIndex + 1, nextEndIndex - 1, preorder, bw);
        pre2post(nextEndIndex, endIndex, preorder, bw);
        bw.write(preorder[startIndex] + "\n");
    }
}