/*
 *http://www.newthinktank.com/2013/03/binary-tree-in-java/

https://ru.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D0%BE%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE_%D0%BF%D0%BE%D0%B8%D1%81%D0%BA%D0%B0
 */
package ru.isalnikov.yandex.binarytree;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class BinaryTree {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    static class Node {

        Node left;

        Node right;

        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getNextByOrder(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return node.right;
        }

        Node curr = root;
        if (node.value < root.value) {
        }

        return null;
    }

    public void add(int value) {
        insert(root, value);
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of "
                        + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("  Traversed " + node.value);
            printInOrder(node.right);
        }
    }

    public void printFrontToBack(Node node, int camera) {
        if (node == null) {
            return;
        }
        if (node.value > camera) {
            // print in order
            printFrontToBack(node.left, camera);
            System.out.println("  Traversed " + node.value);
            printFrontToBack(node.right, camera);
        } else if (node.value < camera) {
            // print reverse order
            printFrontToBack(node.right, camera);
            System.out.println("  Traversed " + node.value);
            printFrontToBack(node.left, camera);
        } else {
            // order doesn't matter
            printFrontToBack(node.left, camera);
            printFrontToBack(node.right, camera);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        BinaryTree binaryTree = new BinaryTree(root);

        binaryTree.add(1);
        binaryTree.add(8);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(9);

        System.out.println("Traversing tree in order");
        binaryTree.printInOrder(root);
        System.out.println("Traversing tree front-to-back from location 7");
        binaryTree.printFrontToBack(root, 7);

        binaryTree.getNextByOrder(root);
    }

}
