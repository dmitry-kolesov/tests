package org.kdb;

public class C {
}


interface BaseI {
    void method();
}
class BaseA implements BaseI{
    @Override
    public void method() {
         System.out.println("A method");
    }
}
class BaseB extends BaseA{
    @Override
    public void method() {
        System.out.println("B method");
    }

    public BaseB(){}
}