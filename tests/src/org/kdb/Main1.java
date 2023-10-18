package org.kdb;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(x -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(String.format("%d: group: %s; name: %s", x, currentThread.getThreadGroup().getName(), currentThread.getName()));
        });

//        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
//
//        map.put("abc", null);
//        Object obj = map.get("abc");
//        System.out.println(obj);
//        Timestamp.valueOf()
//	// write your code here
//        stringComparing();
//
//        B objB = new B();
//        objB.methodToOverride();
//        //A objA =((A)objB);
//        objB.methodFromA();
    }

    private static void stringComparing() {
        String str1 = new String("check equality");
        String str2 = new String("check equality");
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(str2 == str1);
        System.out.println(str2.equals(str1));
    }
}