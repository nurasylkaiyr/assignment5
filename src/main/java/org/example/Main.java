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

        System.out.println(tree.consist(2));
        System.out.println(tree.consist(7));

        for (BST.NodeData<Integer, String> node : tree)
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());

        System.out.println(tree.get(3));
        System.out.println(tree.get(4));

        tree.delete(4);
        System.out.println(tree.get(4));
        System.out.println(tree.consist(4));
    }
}