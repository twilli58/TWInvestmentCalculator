package com.mycompany.tamikowilliamsinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.mycompany.tamikowilliamsinvestmentcalculator.model.InvestmentCalculator;

import java.text.NumberFormat;
import java.util.Currency;

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
    //helper method to call and set investment Calculator
    private void investmentCalcSet() {
        InvestmentCalculator i = new InvestmentCalculator();
        i.setRate(rateValue);
        i.setPeriod(periodValue);
        i.setPayment(payment);
        i.calculateFutureValueTotal();
        String result = i.getFutureValue().toString();
        TextView messageTextView =
                (TextView) findViewById(R.id.message_text_view);

        //The app will display the calculated future value to 2 decimal places,with commas,prefixed by a dollar
        //sign, like $1,146,387.93 $1146387.93
        messageTextView.setText("\u0024 " + result);
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
