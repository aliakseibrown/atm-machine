package com.aliaksei.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.aliaksei.currency.ICurrency;
import com.aliaksei.currency.polish.PolishConversion;

public class ATMController {
    double unit;

    public String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        System.out.println("Wprowadź kwotę do wypłaty: ");
        try {
            input = br.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "The value is incorrect";
    }

    public List<Integer> stringIntoIntegers(String val) {
        double d = Double.parseDouble(val);
        String doubleAsString = String.valueOf(d);
        List<Integer> list = new ArrayList<>();
        String[] arr = new String[2];
        arr = doubleAsString.split("\\.");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        list.add(a);
        list.add(b);
        return list;

        // List<Integer> list = new ArrayList<>();
        // String[] arr = new String[2];
        // int a, b;
        // if (val.contains(".")) {
        // arr = val.split("\\.");
        // try {
        // a = Integer.parseInt(arr[0]);
        // b = Integer.parseInt(arr[1]);
        // } catch (NumberFormatException e) {
        // return null;
        // }
        // } else {
        // a = Integer.parseInt(arr[0]);
        // b = 0;
        // }
        // int i = arr[1].length();
        // // int b = Integer.parseInt(arr[1]);
        // while (i > 0) {
        // b *= 10;
        // i--;
        // }
        // list.add(a);
        // list.add(b);
        // return list;
    }

    public double unit(double zloty, double groszy) {
        groszy = groszy * 0.01;
        unit = zloty + groszy;
        return unit;
    }

    public void withdrawPolishCurrency(List<ICurrency> list, String takeOut) {
        if (list != null) {
            PolishConversion conversion = new PolishConversion();
            ICurrency mainly = list.get(0);
            ICurrency secondary = list.get(1);
            List<Integer> devided = stringIntoIntegers(takeOut);
            double unitTakeOut = unit(devided.get(0), devided.get(1));
            double unitCapacity = unit(mainly.getAmount(), secondary.getAmount());

            if (unitCapacity >= unitTakeOut) {
                System.out.println("Capacity: " + unitCapacity);
                System.out.println("Dla reszty: " + unitTakeOut);
                int remain = conversion.withdraw(mainly, devided.get(0));
                remain = remain * 100 + devided.get(1);
                conversion.withdraw(secondary, remain);
            } else {
                System.out.println("Przepraszamy,\nNie wystarczy środków do wypłaty.");
            }
        }
    }
}
