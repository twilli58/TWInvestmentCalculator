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

public class MainActivity extends AppCompatActivity {


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
        String name, rate, period;
        Double payment, rateValue;
        int periodValue;

        name = paymentText.getText().toString();
        rate = rateText.getText().toString();
        period = periodText.getText().toString();

        if(name.length() == 0) {
            paymentText.setError("Payment is empty");
            return;
        }

        if(rate.length() == 0) {
            rateText.setError("Rate is empty");
            return;
        }

        if(period.length() == 0) {
            periodText.setError("Period is empty");
            return;
        }

        payment = Double.parseDouble(name);
        rateValue = Double.parseDouble(rate);
        periodValue = Integer.parseInt(period);

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
        messageTextView.setText("$" + result);
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
