package com.mycompany.tamikowilliamsinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Miko on 3/8/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

}
