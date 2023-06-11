package com.learning.DSA.dataSturctures.LinkedList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Node {
    @Getter
    @Setter
    Integer value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
