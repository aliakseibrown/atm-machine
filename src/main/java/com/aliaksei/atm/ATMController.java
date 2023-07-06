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

        System.out.println("\nWprowadź kwotę do wypłaty: ");
        try {
            input = br.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "The value is incorrect";
    }

    public List<Integer> stringIntoIntegers(String val) {
        double d = 0.0;
        try {
            d = Double.parseDouble(val);
        } catch (NumberFormatException e) {
            System.out.println("Poproszę wpisać tylko liczby");
        }
        String doubleAsString = String.valueOf(d);
        List<Integer> list = new ArrayList<>();
        String[] arr = new String[2];
        arr = doubleAsString.split("\\.");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        list.add(a);
        list.add(b);
        return list;
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
                if (unitTakeOut != 0.0) {
                    System.out.println("Dostępne środki: " + unitCapacity);
                    System.out.println("Dla reszty: " + unitTakeOut);
                }
                int remain = conversion.withdraw(mainly, devided.get(0));
                remain = remain * 100 + devided.get(1);
                conversion.withdraw(secondary, remain);
            } else {
                System.out.println("Przepraszamy,\nNie wystarczy środków do wypłaty.");
            }
        }
    }
}
