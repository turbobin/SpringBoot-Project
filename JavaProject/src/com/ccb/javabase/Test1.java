package com.ccb.javabase;

public class Test1 {

    public static void main(String[] args) {
        // 1.Integer
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y); //false

        /*
         * Integer.valueOf(123) 会使用缓存中的对象，多次调用会取得同一个对象的引用，
         * 缓存池的大小默认为 -128 ~ 127
         */

        Integer a = Integer.valueOf(123);
        Integer b = Integer.valueOf(123);
        System.out.println(a == b); //true

        // 2. String
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); //false

        /*
         * 如果一个对象已经被创建过了，可以从 String pool 中取得引用，
         * intern()方法可以再运行过程中将字符串添加到 string pool 中
         */
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);   //true
    }
}
