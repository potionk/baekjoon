package bj1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] maxHeap;
    static int leftHeapSize;
    static int[] minHeap;
    static int rightHeapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        minHeap = new int[100001];
        for (int i = 0; i < 100001; i++) {
            minHeap[i] = Integer.MAX_VALUE;
        }
        maxHeap = new int[100001];
        leftHeapSize = 0;
        rightHeapSize = 0;
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i == 0)
                leftHeapInsert(input);
            else if (leftHeapSize == rightHeapSize)
                leftHeapInsert(input);
            else
                rightHeapInsert(input);
            if (leftHeapSize > 0 && rightHeapSize > 0 && (maxHeap[1] > minHeap[1])) {
                int leftData = leftHeapDelete();
                int rightData = rightHeapDelete();
                rightHeapInsert(leftData);
                leftHeapInsert(rightData);
            }
            System.out.println(maxHeap[1]);
        }
    }

    public static void rightHeapInsert(int input) {
        minHeap[++rightHeapSize] = input;
        for (int i = rightHeapSize; i > 1; i /= 2) {
            if (minHeap[i] < minHeap[i / 2])
                minHeapSwap(i, i / 2);
            else
                break;
        }
    }

    public static int rightHeapDelete() {
        if (rightHeapSize == 0)
            return 0;
        int deleteTarget = minHeap[1];
        minHeap[1] = minHeap[rightHeapSize];
        minHeap[rightHeapSize--] = Integer.MAX_VALUE;
        for (int index = 1; index * 2 <= rightHeapSize; ) {
            if (!(minHeap[index * 2] > minHeap[index] && minHeap[index * 2 + 1] > minHeap[index])) {
                if (minHeap[index * 2] >= minHeap[index * 2 + 1]) {
                    minHeapSwap(index, index * 2 + 1);
                    index = index * 2 + 1;
                } else {
                    minHeapSwap(index, index * 2);
                    index = index * 2;
                }
            } else
                break;
        }
        return deleteTarget;
    }


    public static void leftHeapInsert(int input) {
        maxHeap[++leftHeapSize] = input;
        for (int i = leftHeapSize; i > 1; i /= 2) {
            if (maxHeap[i] > maxHeap[i / 2])
                maxHeapSwap(i, i / 2);
            else
                break;
        }
    }

    public static int leftHeapDelete() {
        if (leftHeapSize == 0)
            return 0;
        int deleteTarget = maxHeap[1];
        maxHeap[1] = maxHeap[leftHeapSize];
        maxHeap[leftHeapSize--] = 0;
        for (int index = 1; index * 2 <= leftHeapSize; ) {
            if (!(maxHeap[index * 2] < maxHeap[index] && maxHeap[index * 2 + 1] < maxHeap[index])) {
                if (maxHeap[index * 2] <= maxHeap[index * 2 + 1]) {
                    maxHeapSwap(index, index * 2 + 1);
                    index = index * 2 + 1;
                } else {
                    maxHeapSwap(index, index * 2);
                    index = index * 2;
                }
            } else
                break;
        }
        return deleteTarget;
    }

    public static void maxHeapSwap(int aIndex, int bIndex) {
        int temp = maxHeap[aIndex];
        maxHeap[aIndex] = maxHeap[bIndex];
        maxHeap[bIndex] = temp;
    }

    public static void minHeapSwap(int aIndex, int bIndex) {
        int temp = minHeap[aIndex];
        minHeap[aIndex] = minHeap[bIndex];
        minHeap[bIndex] = temp;
    }
}