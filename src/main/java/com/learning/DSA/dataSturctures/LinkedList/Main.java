package com.learning.DSA.dataSturctures.LinkedList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        list.printList();
        list.removeLast();
        list.prepend(0);
        list.printList();
        list.removeFirst();
        System.out.println(list.get(0));
        list.set(2, 22);
        list.insert(3, 30);
        list.remove(2);
        list.reverse();
        list.printList();

        singleItemListTest();
    }

    private static void singleItemListTest() {
        LinkedList singleItemList = new LinkedList(10);
        singleItemList.removeLast();
        singleItemList.removeLast();
        singleItemList.append(10);
        //singleItemList.removeLast();
        singleItemList.printList();
        singleItemList.reverse();
        singleItemList.printList();
    }
}
