package org.kdb;

public class AlphabetCalc {

    public static void main(String[] args){
        System.out.println(getColumnIndex("ab"));
    }
    public static int getColumnIndex(String templateColumnName) {
        String columnName = templateColumnName.toLowerCase();
        int sum = 0;
        for (int i = 0; i < columnName.toCharArray().length; i++) {
            if(i < columnName.toCharArray().length - 1) {
                sum += 26 * (columnName.charAt(i) - 'a' + 1);//Math.pow(26, columnName.toCharArray().length - i - 1)  +  (columnName.charAt(i) - 'a');
            }
            else{
                sum += (columnName.charAt(i) - 'a');
            }
        }

        return sum;
    }
}