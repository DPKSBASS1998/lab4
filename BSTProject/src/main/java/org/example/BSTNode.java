package org.example;

public class BSTNode {
    static class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BSTNode() {
        this.root = null;
    }

    public void insert(int key, String value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node root, int key, String value) {
        if (root == null) {
            return new Node(key, value);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public String search(int key) {
        Node result = searchRec(root, key);
        return (result != null) ? result.value : null;
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(Node root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print("(" + root.key + ", " + root.value + ") ");
            inorderTraversalRec(root.right);
        }
    }
}

