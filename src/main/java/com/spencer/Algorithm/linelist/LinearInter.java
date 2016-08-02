package com.spencer.Algorithm.linelist;

/**
 * Created by spencer on 16/8/2.
 *
 * 线性表dta
 *
 *
 */
public interface LinearInter {

    public void add(Object o);

    public void add(int position, Object o);

    public Object remove(int position);

    public boolean replace(int position, Object newEntry);

    public Object get(int position);

    public void clear();

    public void display();

    public int getLength();

    public boolean isFull();

    public boolean contains(Object entry);
}
