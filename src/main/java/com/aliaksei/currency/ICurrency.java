package com.aliaksei.currency;

public interface ICurrency {
    int getFifty();

    int getTwenty();

    int getTen();

    int getFive();

    int getTwo();

    int getOne();

    String getCurrencyName();

    // void setFifty(int fifty);
    // void setTwenty(int twenty);
    // void setTen(int ten);
    // void setFive(int five);
    // void setTwo(int two);
    // void setOne(int one);

    void setFiftyMinus(int value);

    void setTwentyMinus(int value);

    void setTenMinus(int value);

    void setFiveMinus(int value);

    void setTwoMinus(int value);

    void setOneMinus(int value);

    int getAmount();

    public String toString();
}
