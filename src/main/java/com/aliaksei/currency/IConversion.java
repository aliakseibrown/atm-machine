package com.aliaksei.currency;

public interface IConversion {
    double unit(double main, double secondary);

    int withdraw(ICurrency currency, int takeOut);
}
