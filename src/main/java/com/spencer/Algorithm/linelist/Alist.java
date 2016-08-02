package com.spencer.Algorithm.linelist;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by spencer on 16/8/2.
 * 用数组实现线性表
 *
 *
 */
public class Alist implements  LinearInter {

    private int capcaity; //数组长度
    private int length;//数据实际长度


   private Object[] enterys;

    public Alist() {
        capcaity = 10;
        length = 0;
        enterys = new Object[capcaity];
    }


    @Override
    public void add(Object o) {
        if (length > capcaity) {
            throw new RuntimeException("length > capcaity");
        }
        enterys[length] = o;
        length++;
    }

    @Override
    public void add(int position, Object o) {
        if (position > capcaity || position < 0) {
            throw new RuntimeException("position > capcaity ,or position < 0");
        }

        if (position > length) {
            enterys[position] = o;
        }

        if (position < length) { //需要移动数组
            Object tmp = enterys[position]; //保存
            enterys[position + 1] = tmp;
            enterys[position] = o;
            for(int i = position+1 ;position < length ;i++) {
                Object o1 = enterys[i];
                enterys[i + 1] = o1;
            }
        }
        length++;
    }


    //删除的时候
    @Override
    public Object remove(int position) {
        return null;
    }

    @Override
    public boolean replace(int position, Object newEntry) {
        return false;
    }

    @Override
    public Object get(int position) {
        return enterys[position];
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {
      //  if(enterys)
        /*for (Object o : enterys) {
            System.out.println();
        }*/
        String arrays = "[]";
        if (length == 0) {
            System.out.println(arrays);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();

     for(int i=0; i<length;i++) {
         if (i == 0) {
           //  System.out.println("[" + enterys[i] + "]");
             stringBuffer.append("[ " + enterys[i] + ",");
         } else if (i == length - 1) {
             stringBuffer.append(enterys[i] + " ]");
         } else {
             stringBuffer.append(enterys[i] + ",");
         }
     }

        System.out.println(stringBuffer.toString());


    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isFull() {
        return length==capcaity;
    }

    @Override
    public boolean contains(Object entry) {
        return false;
    }


    public static void main(String[] args) {
        Object[] objects = new Object[10];
        System.out.println(objects[0]);

        List list = new ArrayList();
        list.add("xxg");
        list.add("zst");
        list.add("jasshine");

        ListIterator listIterator = list.listIterator();
        System.out.println(listIterator.hasPrevious());
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            //System.out.println(listIterator.previous());
        }

        System.out.println("===========================================");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }


        Alist alist = new Alist();
        alist.add(13);
        alist.add(14);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);
        alist.add(15);



        System.out.println("alist legth ===== >" + alist.length);

        alist.display();


    }
}
