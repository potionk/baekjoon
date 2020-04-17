package bj7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Data> minQueue, maxQueue;
    static int index, count;
    static Set<Integer> isDelete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            minQueue = new PriorityQueue<>(new MinQueue());
            maxQueue = new PriorityQueue<>(new MaxQueue());
            isDelete = new HashSet<>();
            index = 0;
            count = 0;
            int cmdSize = Integer.parseInt(br.readLine());
            for (int j = 0; j < cmdSize; j++) {
                String[] input = br.readLine().split(" ");
                if (input[0].equals("I")) {
                    insert(Long.parseLong(input[1]));
                } else if (input[0].equals("D")) {
                    if (Integer.parseInt(input[1]) == -1)
                        delete(true);
                    else
                        delete(false);
                }
                sync();
            }
            if (minQueue.size() == 0)
                System.out.println("EMPTY");
            else
                System.out.println(getMax() + " " + getMin());
        }
    }

    public static void insert(long x) {
        minQueue.add(new Data(index, x));
        maxQueue.add(new Data(index, x));
        index++;
    }

    public static void delete(boolean isMin) {
        Data deleteData;
        if (isMin && minQueue.size() > 0) {
            deleteData = minQueue.poll();
            isDelete.add(deleteData.getIndex());
        } else if (maxQueue.size() > 0) {
            deleteData = maxQueue.poll();
            isDelete.add(deleteData.getIndex());
        }
    }

    public static long getMin() {
        return minQueue.peek().getValue();
    }

    public static long getMax() {
        return maxQueue.peek().getValue();
    }

    public static void sync() {
        while (!maxQueue.isEmpty() && isDelete.contains(maxQueue.peek().getIndex()))
            maxQueue.poll();
        while (!minQueue.isEmpty() && isDelete.contains(minQueue.peek().getIndex()))
            minQueue.poll();
    }
}

class Data {
    int index;
    long value;

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    Data(int index, long value) {
        this.index = index;
        this.value = value;
    }
}

class MaxQueue implements Comparator<Data> {
    @Override
    public int compare(Data m1, Data m2) {
        return Long.compare(m2.value, m1.value);
    }
}

class MinQueue implements Comparator<Data> {
    @Override
    public int compare(Data m1, Data m2) {
        return Long.compare(m1.value, m2.value);
    }
}