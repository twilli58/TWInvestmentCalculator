package com.mycompany.tamikowilliamsinvestmentcalculator.model;

/**
 * Created by Miko on 3/3/2016.
 */
public class InvestmentCalculator {
    private Double payment;
    private Double rate;
    private Integer period;
    private Double futureValue;

    public InvestmentCalculator() {
        this.payment = 0.00;
        this.rate = 0.0;
        this.period = 0;
        this.futureValue = 0.0;
    }
    public Double calculateFutureValueTotal() {

        if(rate == 0)  {
            futureValue = payment * period;
        } else if(period == 0) {
            futureValue = payment;
        } else if(payment == 0) {
            futureValue = payment;
        } else {
            futureValue = payment*(Math.pow(1 + rate/100, period)-1)/(rate/100);
            futureValue = ((double) Math.round(futureValue*100))/100;
        }
        return futureValue;
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getFutureValue() {
        return futureValue;
    }

    public void setFutureValue(Double futureValue) {
        this.futureValue = futureValue;
    }
}
