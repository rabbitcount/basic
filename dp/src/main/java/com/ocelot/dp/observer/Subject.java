package com.ocelot.dp.observer;

public class Subject {

    public static void main(String[] args) {
        int state = 32;
        System.out.println( (((int) (state >>> 33) + 1)) / (0x1.0p31) );
        System.out.println(((double) ((int) (state >>> 33) + 1)) / (0x1.0p31));
    }
}
