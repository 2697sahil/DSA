package com.learning.DSA.dataSturctures.LinkedList;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
        log.debug("new list initialized, list: {}", this);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.length++;
        log.debug("new node appended to the list, list: {}", this);
    }

    public Integer removeLast() {
        if (null == this.head) {
            log.warn("No item in the list to remove");
            return null;
        }
        Node node = this.head;
        if (null == this.head.next) {
            this.head = null;
            this.tail = null;
        } else {
            Node temp = node;
            while (null != temp.next.next) {
                temp = temp.next;
            }
            this.tail = temp;
            node = temp.next;
            this.tail.next = null;
        }
        this.length--;
        log.debug("last node: {} removed. List after removal: {}", node, this);
        return node.getValue();
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
        }
        this.head = newNode;
        this.length++;
        log.debug("new node prepended to the list, list: {}", this);
    }

    public Integer removeFirst() {
        if (null == this.head) {
            log.warn("No item in the list to remove");
            return null;
        }
        Node node = this.head;
        if (null == this.head.next) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = node.next;
        }
        this.length--;
        log.debug("first node: {} removed. List after removal: {}", node, this);
        return node.getValue();
    }

    public Integer get(int index) {
        if (index >= length) {
            log.error("Index out of bound");
            return null;
        }
        Node node = this.head;
        int i = 0;
        while (i != index) {
            node = node.next;
            i++;
        }
        log.debug("node found at index {}, is {}", index, node);
        return node.getValue();
    }

    public void set(int index, int value) {
        if (index >= length) {
            log.error("Index out of bound");
        }
        Node node = this.head;
        int i = 0;
        while (i != index) {
            node = node.next;
            i++;
        }
        node.setValue(value);
        log.debug("new value set at index {}, list after set {}", index, this);
    }

    public void insert(int index, int value) {
        if (index > length) {
            log.error("Index out of bound, value not set");
        }
        Node node = this.head;
        int i = 0;
        while (i != index - 1) {
            node = node.next;
            i++;
        }
        Node newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
        this.length++;
        log.debug("new node set at index: {}. list after setting the node {}", index, this);
    }

    public Integer remove(int index) {
        if (index >= length) {
            log.error("Index out of bound");
        }
        Node node = this.head;
        int i = 0;
        while (i != index - 1) {
            node = node.next;
            i++;
        }
        Node removalNode = node.next;
        node.next = removalNode.next;
        this.length--;
        log.debug("node at index {} removed, list after removal {}", index, this);
        return removalNode.getValue();
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        Node after;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printList() {
        if (null == this) {
            log.error("This is a null linkedList");
            return;
        }
        Node temp = this.head;
        while (null != temp) {
            System.out.println();
            System.out.printf("Node value: %d", temp.getValue());
            temp = temp.next;
        }
        System.out.println();
    }
}
