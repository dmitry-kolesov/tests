package org.kdb;

public class B extends A{

    @Override
    public void methodToOverride(){
        System.out.println("B class method");
    }

    public void methodFromA(){
        super.methodToOverride();
    }
}
