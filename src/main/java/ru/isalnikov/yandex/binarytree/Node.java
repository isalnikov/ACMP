/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex.binarytree;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    protected T value;
    protected Node parent;
    protected Node left;
    protected Node right;

    public Node() {
    }

    public Node(Node parent, T value ) {
        this.value = value;
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node<T> o) {
        return getValue().compareTo(o.getValue());

    }

}
