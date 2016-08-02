package com.spencer.Algorithm.linelist;

/**
 * Created by apple on 16/8/2.
 */
public class HashSet {
    public static void main(String[] args) {
        java.util.HashSet hashSet = new java.util.HashSet();

        hashSet.add("xxg");
        hashSet.add("xxg");

        String x1 = new String("JASSHINE");
        String x2 = new String("JASSHINE");

        System.out.println(x1.hashCode());
        System.out.println(x2.hashCode());
        hashSet.add(x1);
        hashSet.add(x2);
        System.out.println(hashSet);

        Demon demon = new Demon();
        Demon demon1 = new Demon();
        System.out.println(demon.hashCode());
        System.out.println(demon1.hashCode());
        System.out.println( demon==demon1);
        System.out.println(demon.equals(demon1));

        hashSet.add(demon);
        hashSet.add(demon1);
        System.out.println(hashSet);
    }
}

class Demon{

    @Override
    public int hashCode() {
        return 10;
    }
}
