package bj9934;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int inorderIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int maxDepth = Integer.parseInt(br.readLine());
        String[] inorderStr = br.readLine().split(" ");
        int[] inorder = new int[inorderStr.length];
        for (int i = 0; i < inorderStr.length; i++) {
            inorder[i] = Integer.parseInt(inorderStr[i]);
        }
        int[] depthArr = new int[(int) Math.pow(2, maxDepth)];
        analyzeInorder(1, 1, inorder, depthArr, maxDepth);
        inorderIdx = 0;
        int lineBreakCount = 0;
        int nextLineBreakCount = 1;
        for (int i = 1; i < depthArr.length; i++) {
            bw.write(depthArr[i] + " ");
            lineBreakCount++;
            if (lineBreakCount == nextLineBreakCount) {
                nextLineBreakCount *= 2;
                lineBreakCount = 0;
                bw.write("\n");
            }
        }
        br.close();
        bw.close();
    }

    public static void analyzeInorder(int idx, int depth, int[] inorder, int[] depthArr, int maxDepth) {
        if (depth != maxDepth) {
            analyzeInorder(idx * 2, depth + 1, inorder, depthArr, maxDepth);
        }
        depthArr[idx] = inorder[inorderIdx++];
        if (depth != maxDepth) {
            analyzeInorder(idx * 2 + 1, depth + 1, inorder, depthArr, maxDepth);
        }
    }
}