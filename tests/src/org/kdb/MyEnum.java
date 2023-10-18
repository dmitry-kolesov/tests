package org.kdb;

public enum MyEnum implements EnumIntersace{
    ;

    @Override
    public int getValue() {
        return ordinal() + 1;
    }
}