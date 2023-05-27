package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class BST<K extends Comparable<K>, V> implements Iterable<BST.NodeData<K, V>> {
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            }
        }
    public void put(K key, V value){
        root = put(root, key, value);
    }
    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;

        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.value : null;
    }
    private Node get(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key){
        root = delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = deleteMin(node.right);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }
    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public int size() {
        return size;
    }
    @Override
    public Iterator<NodeData<K, V>> iterator() {
        List<NodeData<K, V>> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        return nodes.iterator();
    }

    private void inOrderTraversal(Node node, List<NodeData<K, V>> nodes) {
        if (node == null)
            return;

        inOrderTraversal(node.left, nodes);
        nodes.add(new NodeData<>(node.key, node.value));
        inOrderTraversal(node.right, nodes);
    }

    public static class NodeData<K, V> {
        private K key;
        private V value;

        public NodeData(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public boolean consist(K key) {
        boolean check = consist(root, key);
        return check;
    }
    private boolean consist (Node curr, K key) {
        if(curr == null){
            return false;
        }
        else if(key.equals(curr.key)){
            return true;
        }
        int c = key.compareTo(curr.key);
        if(c<0){
            return consist(curr.left, key);
        }
        else {return consist(curr.right, key);}
    }
}
