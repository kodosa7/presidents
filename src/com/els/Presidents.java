package com.els;

import java.util.*;

public class Presidents {

    // fill up dictionary method
    public Map<Integer, String> getPresidentsMap() {
        Map<Integer, String> presidents = new LinkedHashMap<>();
        presidents.put(1918, "Tomas Garrigue Masaryk");
        presidents.put(1935, "Edvard Benes");
        presidents.put(1938, "Emil Hacha");
        presidents.put(1948, "Klement Gottwald");
        presidents.put(1953, "Antonin Zapotocky");
        presidents.put(1957, "Antonin Novotny");
        presidents.put(1968, "Ludvik Svoboda");
        presidents.put(1975, "Gustav Husak");
        presidents.put(1989, "Vaclav Havel");
        presidents.put(2003, "Vaclav Klaus");
        presidents.put(2013, "Milos Zeman");
        presidents.put(9999, "last item");
        return presidents;
    }

    public String showResult(Map<Integer, String> presidents, int year) {
        int lastPass = -1;
        for (int currentPass : presidents.keySet()) {
            if (year >= lastPass && year < currentPass) {
                return "In the year " + year + ", the president was " + presidents.get(lastPass) + " (since " + lastPass + ").";
            }
            lastPass = currentPass;
        }
        return "";
    }

    // user input method
    public int getYearAndTest() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Please input a year (1918-2021): ");
            int yearEntered = scan.nextInt();

            if (yearEntered < 1918 || yearEntered > 2021) {
                System.out.println("Wrong entry!");
                System.exit(0);
            }
            return yearEntered;
        } catch(InputMismatchException e) {
            System.out.println("Wrong entry!");
            System.exit(0);
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Czech(oslovak) Presidents\n----------------");
        Presidents myClassInstantion = new Presidents();  // instantiate class
        int yearEntered = myClassInstantion.getYearAndTest();  // get year number and test if input is ok

        Map<Integer, String> presidents = myClassInstantion.getPresidentsMap();  // get Map array
        System.out.println(myClassInstantion.showResult(presidents, yearEntered));  // show result
    }
}