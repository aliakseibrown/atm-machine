package com.aliaksei;

import java.util.*;

import com.aliaksei.atm.ATMController;
import com.aliaksei.currency.ICurrency;
import com.aliaksei.currency.polish.PolishCurrency;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        ATMController controller = new ATMController();
        List<ICurrency> polishCurrency = new ArrayList<>();
        String input = "";

        PolishCurrency zloty = new PolishCurrency(0, 0, 0, 1, 3, 5, "zł");
        PolishCurrency groszy = new PolishCurrency(10, 20, 200, 100, 100, 10000, "gr");
        polishCurrency.add(zloty);
        polishCurrency.add(groszy);

        System.out.println("Print 'q' to exit");
        while (true) {
            input = controller.getInput();
            if (input.equals("q"))
                break;
            controller.withdrawPolishCurrency(polishCurrency, input);
        }
    }
}
