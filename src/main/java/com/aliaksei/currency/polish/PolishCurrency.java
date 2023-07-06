package com.aliaksei.currency.polish;

import com.aliaksei.currency.ICurrency;

public class PolishCurrency implements ICurrency {
    private int fifty;
    private int twenty;
    private int ten;
    private int five;
    private int two;
    private int one;
    private String currencyName;

    public PolishCurrency() {
    }

    public PolishCurrency(int fifty, int twenty, int ten, int five, int two, int one, String currencyName) {
        this.fifty = fifty;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.two = two;
        this.one = one;
        this.currencyName = currencyName;
    }

    public int getFifty() {
        return this.fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getTwenty() {
        return this.twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getTen() {
        return this.ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFive() {
        return this.five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTwo() {
        return this.two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getOne() {
        return this.one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public PolishCurrency fifty(int fifty) {
        setFifty(fifty);
        return this;
    }

    public PolishCurrency twenty(int twenty) {
        setTwenty(twenty);
        return this;
    }

    public PolishCurrency ten(int ten) {
        setTen(ten);
        return this;
    }

    public PolishCurrency five(int five) {
        setFive(five);
        return this;
    }

    public PolishCurrency two(int two) {
        setTwo(two);
        return this;
    }

    public PolishCurrency one(int one) {
        setOne(one);
        return this;
    }

    @Override
    public void setFiftyMinus(int value) {
        this.fifty = fifty - value;
    }

    @Override
    public void setTwentyMinus(int value) {
        this.twenty = twenty - value;
    }

    @Override
    public void setTenMinus(int value) {
        this.ten = ten - value;
    }

    @Override
    public void setFiveMinus(int value) {
        this.five = five - value;
    }

    @Override
    public void setTwoMinus(int value) {
        this.two = two - value;
    }

    @Override
    public void setOneMinus(int value) {
        this.one = one - value;

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PolishCurrency)) {
            return false;
        }
        PolishCurrency groszy = (PolishCurrency) o;
        return fifty == groszy.fifty && twenty == groszy.twenty && ten == groszy.ten && five == groszy.five
                && two == groszy.two && one == groszy.one;
    }

    @Override
    public int getAmount() {
        int amount = 0;
        amount = fifty * 50 + twenty * 20 + ten * 10 + five * 5 + two * 2 + one * 1;
        return amount;
    }

    @Override
    public String toString() {
        return "50 " + currencyName + ": " + getFifty() + " szt.\n" +
                "20 " + currencyName + ": " + getTwenty() + " szt.\n" +
                "10 " + currencyName + ": " + getTen() + " szt.\n" +
                "5 " + currencyName + ": " + getFive() + " szt.\n" +
                "2 " + currencyName + ": " + getTwo() + " szt.\n" +
                "1 " + currencyName + ": " + getOne() + " szt.\n" +
                " ";
    }

}