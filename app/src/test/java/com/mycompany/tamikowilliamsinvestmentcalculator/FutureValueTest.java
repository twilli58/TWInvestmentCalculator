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
        i.setRate(6.0);
        i.setPeriod(10);
        i.setPayment(300.00);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        assertEquals("3954.24", result);

    }

    @Test
    public void calculates_isOddValues()throws Exception {
    InvestmentCalculator i = new InvestmentCalculator();
    i.setRate(0.0);
    i.setPeriod(10);
    i.setPayment(300.0);
    i.calculateFutureValueTotal();
    String result = i.getFutureValue().toString();
    assertEquals("300.0", result);
    i.setRate(6.0);
    i.setPeriod(0);
    i.calculateFutureValueTotal();
    result = i.getFutureValue().toString();
    assertEquals("300.0", result);
    }
}