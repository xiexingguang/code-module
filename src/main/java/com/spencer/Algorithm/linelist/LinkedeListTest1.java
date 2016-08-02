package com.spencer.Algorithm.linelist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by spencer on 16/8/2.
 */
public class LinkedeListTest1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("zst");
        linkedList.add("stone");
        linkedList.add("jasshine");
        linkedList.add("spener");

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            // linkedList.add("xxg");
             System.out.println(iterator.next());

        }
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.add("xxg");
            System.out.println(listIterator.next());
        }
    }

}
