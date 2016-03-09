package com.mycompany.tamikowilliamsinvestmentcalculator;

        import com.mycompany.tamikowilliamsinvestmentcalculator.model.InvestmentCalculator;

        import org.junit.Test;

        import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class FutureValueTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void calculates_isNormalValues() throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(3.0);
        i.setPeriod(10);
        i.setPayment(1000.00);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("11463.88", result);

    }
    @Test
    public void calculates_isNormalValuesPercents() throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(3.4);
        i.setPeriod(10);
        i.setPayment(600.00);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("7006.39", result);
    }

    @Test
    public void calculates_isOddValuesInRate()throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(0.0);
        i.setPeriod(10);
        i.setPayment(1000.0);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("10000.0", result);
    }
    @Test
    public void calculates_isOddValuesInPeriod()throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(2.3);
        i.setPeriod(0);
        i.setPayment(400.0);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("400.0", result);
    }
    @Test
    public void calculates_isOddValuesInPayment()throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(0.3);
        i.setPeriod(5);
        i.setPayment(0.0);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("0.0", result);
    }
    @Test
    public void calculates_isOddValuesInAll()throws Exception {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(0.0);
        i.setPeriod(0);
        i.setPayment(0.0);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("0.0", result);
    }
}