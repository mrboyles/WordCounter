package com.m3c.jc.View;

public class DisplayManager {

    public static void displayResults(String result, int count) {
        System.out.println("The word '" + result + "' appears " + count + " times");
    }

    public static void displayReading(String fileName) {
        System.out.println("Reading from file at " + fileName);
    }
}
