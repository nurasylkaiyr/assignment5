package org.example;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Value 5");
        tree.put(2, "Value 2");
        tree.put(8, "Value 8");
        tree.put(1, "Value 1");
        tree.put(4, "Value 4");
        tree.put(7, "Value 7");
        tree.put(9, "Value 9");

        for (BST.NodeData<Integer, String> node : tree)
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
    }
}