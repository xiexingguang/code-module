package com.spencer.JDK.collection;

import java.util.LinkedList;

/**
 * Created by apple on 16/8/1.
 */
public class LinkedListDemo {


    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.add("javao1");
        link.add("javao2");

        link.addFirst("javao3");
        link.addFirst("java04");
        System.out.println(link);
        System.out.println(link.getFirst());
    }
}
