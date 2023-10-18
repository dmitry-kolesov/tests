package org.kdb;

public class EnumTestClass {

    public String getValueBySwitch(enumTest val) {
        String res;
        switch (val) {
            case Val1:
                res = enumTest.Val1.name();
            case Val2:
                break;
            case Val3:
                break;
            case Val4:
                break;
        }
        return "";
    }
}