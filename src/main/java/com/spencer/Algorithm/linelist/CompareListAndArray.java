package com.spencer.Algorithm.linelist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by spencer on 16/8/2.
 *
 * 测试arrayList 跟 linkedList的写入等其他性能对比
 *
 * 以及查询效率
 *
 * JDK 1.8
 *
 *
 */
public class CompareListAndArray {

    public static void main(String[] args) {
        System.out.println("比较 arraylist 和 linkedList 在50w数据的写入时间差异");
        insertArrayList();
        insertLinkedList();
        System.out.println("比较 arraylist 和 linkedList 在50w数据的删除的时间差异");
    }

    public static void insertArrayList() {
        long begintime = System.currentTimeMillis();
        Object object = new Object();
        for(int i=0;i<500;i++) {
            List list = new ArrayList(600); //加上600,花费时间为2ms
            list.add(object);
        }
        //花了 7ms?
        System.out.println("arraylist wastTime:" + (System.currentTimeMillis()-begintime) + "ms");
    }

    public static void insertLinkedList() {
        long begintime = System.currentTimeMillis();

        Object o = new Object();
        for(int i=0;i<500;i++) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(o);
        }
        //花了 1ms? linkedList 还快一点
        System.out.println("linkedList wastTime:" + (System.currentTimeMillis()-begintime) + "ms");

    }



    public static void arraylistRemove() {

    }


    public static void linkdedListRemove() {

    }


}
