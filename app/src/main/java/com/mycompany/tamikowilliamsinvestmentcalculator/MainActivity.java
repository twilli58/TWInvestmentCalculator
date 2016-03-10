package com.mycompany.tamikowilliamsinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mycompany.tamikowilliamsinvestmentcalculator.model.InvestmentCalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String name, rate, period;
    Double payment, rateValue;
    int periodValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void didTapCalculateButton(View view) {
        EditText paymentText = (EditText) findViewById(R.id.payment_edit_text);
        EditText rateText = (EditText) findViewById(R.id.rate_edit_text);
        EditText periodText = (EditText) findViewById(R.id.period_edit_text);

        name = paymentText.getText().toString();
        rate = rateText.getText().toString();
        period = periodText.getText().toString();

        if(name.length() == 0) {
            paymentText.setError("Please enter payment amount");
            return;
        }

        if(rate.length() == 0) {
            rateText.setError("Please enter a Rate");
            return;
        }

        if(period.length() == 0) {
            periodText.setError("Please enter Period");
            return;
        }

        payment = Double.parseDouble(name);
        rateValue = Double.parseDouble(rate);
        periodValue = Integer.parseInt(period);

        this.investmentCalcSet();

    }
    //helper method to call and format investment Calculator
    private void investmentCalcSet() {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(rateValue);
        i.setPeriod(periodValue);
        i.setPayment(payment);
        i.calculateFutureValueTotal();
        String result = formatAnswer(i.getFutureValue());

        TextView messageTextView =
                (TextView) findViewById(R.id.message_text_view);

        messageTextView.setText("\u0024 " + result);

    }

    private String formatAnswer(Double result) {
        int num = result.intValue();
        Double numTemp = result*100;
        numTemp = numTemp - num*100;
        int frac = numTemp.intValue();
        System.out.println(frac);
        String answer = "";
        while(num/1000 > 0) {
            if(num%1000 == 0) {
                answer = ",000" + answer;
            } else if(num%1000 < 10) {
                answer = ",00" + num%1000 + answer;
            } else if(num%1000 < 100) {
                answer = ",0" + num%1000 + answer;
            } else answer = "," + String.valueOf(num%1000) + answer;
            num = num/1000;
        }
        answer = String.valueOf(num) + answer;
        return answer + "." + String.valueOf(frac);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
