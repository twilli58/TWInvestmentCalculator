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
        double futureValue = 0;
        if(rate == 0)  {
            futureValue = payment;
        } else if(period == 0) {
            futureValue = payment;
        } else {
            futureValue = payment*(Math.pow(1 + rate, period)-1)/(rate);
        }
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getPeriod() {
        return period;
    }

    public void setPeriod(Double period) {
        this.period = period;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
