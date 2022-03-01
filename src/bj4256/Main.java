package bj4256;

import java.io.*;

public class Main {
    static int[] preorder, inorder, inorderIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int nodeNum = Integer.parseInt(br.readLine());
            String[] preorderStr = br.readLine().split(" ");
            String[] inorderStr = br.readLine().split(" ");
            preorder = new int[nodeNum];
            inorder = new int[nodeNum];
            inorderIdx = new int[nodeNum];
            for (int i = 0; i < nodeNum; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
                inorder[i] = Integer.parseInt(inorderStr[i]);
                inorderIdx[inorder[i] - 1] = i;
            }
            printPostorder(0, nodeNum - 1, 0, bw);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void printPostorder(int start, int end, int preorderIdx, BufferedWriter bw) throws IOException {
        if (start > end) {
            return;
        }
        int rootIdxInInorder = inorderIdx[preorder[preorderIdx] - 1];
        printPostorder(start, rootIdxInInorder - 1, preorderIdx + 1, bw);
        printPostorder(rootIdxInInorder + 1, end, preorderIdx + rootIdxInInorder - start + 1, bw);
        bw.write(inorder[rootIdxInInorder] + " ");
    }
}
