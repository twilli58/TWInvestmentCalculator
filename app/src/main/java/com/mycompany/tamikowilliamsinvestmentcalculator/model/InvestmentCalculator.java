package com.mycompany.tamikowilliamsinvestmentcalculator.model;

/**
 * Created by Miko on 3/3/2016.
 */
public class InvestmentCalculator {
    private Double payment;
    private Double rate;
    private Double period;
    private Double total;

    public InvestmentCalculator() {
        this.payment = 0.0;
        this.rate = 0.0;
        this.period = 0.0;
    }

    public void futureValue(double rate, double period, double payment) {
        double futureValue = payment*Math.pow(1 + rate, 12*period);
    }

}
