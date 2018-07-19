package com.gitdetective

import com.google.common.collect.Lists

import java.security.AccessController
import java.security.PrivilegedAction

/**
 * Hello world!
 */
class App2 {
    static {
        new MyClass().myMethod()
        System.out.println(String.valueOf(10))
    }
    static {
        final int defaultValue = 64
        int value = defaultValue
        try {
            value = Integer.parseInt(AccessController.doPrivileged(new PrivilegedAction<String>() {
                String run() {
                    return System.getProperty("test", String.valueOf(defaultValue))
                }
            }))
        } catch (Exception ignored) {
        }
        System.out.println(value)
    }

    static void main(String[] args) {
        System.out.println("Hello World!")

        List arrayList = Lists.newArrayList()
        MyClass yay = new MyClass()
        arrayList.add(yay)

        yay.myMethod()
        System.out.println(arrayList.size())
    }

    static void anotherOne() {
        MyClass yay = new MyClass()
        yay.myMethod()
    }
}
