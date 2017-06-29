package com.counter.test.moneycounter;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class UnitTest {

    @Test
    public void checkByteToText() throws Exception {
        assertEquals(NfcReadingActivity.bytesToHexString("000001".getBytes()), "0x303030303031");
    }
}