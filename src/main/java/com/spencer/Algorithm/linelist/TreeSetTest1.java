package com.spencer.Algorithm.linelist;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by apple on 16/8/2.
 * Set
 */
public class TreeSetTest1 {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //treeSet.add("abc");
       // treeSet.add("abc");
      //  treeSet.add(new Object());
       // treeSet.add(new Object());
     //   treeSet.add("def");
       // treeSet.add("mgk");

        treeSet.add(new TestDemon(1));
        treeSet.add(new TestDemon(4));
        treeSet.add(new TestDemon(7));
        treeSet.add(new TestDemon(1));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); //set 是无序的
        }

       // System.out.println(treeSet.);
        System.out.println(treeSet);
    }
}


class TestDemon implements  Comparable {

    private int age;

    public TestDemon(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TestDemon)) {
            throw new RuntimeException();
        }

        TestDemon testDemon = (TestDemon) o;
        if (testDemon.age > this.age) {
            return 1;
        } else if (testDemon.age == this.age) {
            return 0;
        }else{
            return -1;
        }
    }

    public String toString() {
        return "testDemon :" + this.age;
    }
}