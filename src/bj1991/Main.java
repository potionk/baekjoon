package bj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Node> tree=new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] readData=br.readLine().split(" ");
            tree.put(readData[0],new Node(readData[1],readData[2]));
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    public static void preOrder(String node) {
        if (!(node.equals("."))) {
            System.out.print(node);
            preOrder(tree.get(node).left);
            preOrder(tree.get(node).right);
        }
    }

    public static void inOrder(String node) {
        if (!(node.equals("."))) {
            inOrder(tree.get(node).left);
            System.out.print(node);
            inOrder(tree.get(node).right);
        }
    }

    public static void postOrder(String node) {
        if (!(node.equals("."))) {
            postOrder(tree.get(node).left);
            postOrder(tree.get(node).right);
            System.out.print(node);
        }
    }
}

class Node {
    String left, right;
    public Node(String left, String right) {
        this.left = left;
        this.right = right;
    }
}
