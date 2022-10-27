package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this. root = null;
        this.size = 0;
    }

    public BSTMap(K key, V val) {
        this.root = new Node(key, val);
        this.size = 1;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException();
        if (this == null) return false;

        return containsKey(root, key);
    }

    public boolean containsKey(Node root, K key) {
        if (root == null) return false;
        int cmp = key.compareTo(root.key);
        if (cmp > 0) return containsKey(root.right, key);
        else if (cmp < 0) return containsKey(root.left, key);
        else return true;
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException();
        if (this == null) return null;
        return get(root, key);
    }

    public V get(Node root, K key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp > 0) return get(root.right, key);
        else if (cmp < 0) return get(root.left, key);
        else return root.val;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        put(this.root, key, value);
    }

    public Node put(Node root, K key, V value) {
        if (root == null) {
            root = new Node(key, value);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.val = value;
        }
        return root;
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
