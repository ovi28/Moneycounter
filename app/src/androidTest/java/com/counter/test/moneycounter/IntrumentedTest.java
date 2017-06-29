package com.counter.test.moneycounter;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class IntrumentedTest {

    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();
    }

    @Test
    public void writeToFile() throws IOException {
        Io.writeToFile(instrumentationCtx,"TEST", "file.txt");


    }
}
