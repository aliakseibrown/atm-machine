package com.aliaksei.currency.polish;

import com.aliaksei.currency.ICurrency;

public class PolishConversion extends PolishCurrency {

    public int withdraw(ICurrency currency, int takeOut) {
        int available;
        int value;
        while (takeOut > 0) {
            if (currency.getFifty() != 0) {
                value = takeOut / 50;
                available = currency.getFifty();
                if (available >= value) {
                    currency.setFiftyMinus(value);
                } else {
                    value = available;
                    currency.setFiftyMinus(available);
                }
                takeOut -= value * 50;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 50 " + currency.getCurrencyName());
            }
            if (currency.getTwenty() != 0) {
                value = takeOut / 20;
                available = currency.getTwenty();
                if (available >= value) {
                    currency.setTwentyMinus(value);
                } else {
                    value = available;
                    currency.setTwentyMinus(available);
                }
                takeOut -= value * 20;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 20 " + currency.getCurrencyName());
            }
            if (currency.getTen() != 0) {
                value = takeOut / 10;
                available = currency.getTen();
                if (available >= value) {
                    currency.setTenMinus(value);
                } else {
                    value = available;
                    currency.setTenMinus(available);
                }
                takeOut -= value * 10;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 10 " + currency.getCurrencyName());
            }
            if (currency.getFive() != 0) {
                value = takeOut / 5;
                available = currency.getFive();
                if (available >= value) {
                    currency.setFiveMinus(value);
                } else {
                    value = available;
                    currency.setFiveMinus(available);
                }
                takeOut -= value * 5;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 5 " + currency.getCurrencyName());
            }
            if (currency.getTwo() != 0) {
                value = takeOut / 2;
                available = currency.getTwo();
                if (available >= value) {
                    currency.setTwoMinus(value);
                } else {
                    value = available;
                    currency.setTwoMinus(available);
                }
                takeOut -= value * 2;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 2 " + currency.getCurrencyName());
            }
            if (currency.getOne() != 0) {
                value = takeOut;
                available = currency.getOne();
                if (available >= value) {
                    currency.setOneMinus(value);
                } else {
                    value = available;
                    currency.setOneMinus(available);
                }
                takeOut -= value;
                if (value != 0)
                    System.out.println("Wydaj " + value + " monet 1 " + currency.getCurrencyName());
            }
            return takeOut;
        }
        return takeOut;
    }

}
