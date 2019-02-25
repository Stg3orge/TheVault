package com.example.calcapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    MainActivity mainActivity;

    @Before
    public void invSetup() {
        mainActivity = new MainActivity();
    }

    @Test
    public void multiplicationCal1() {
        float firstInput = 5;
        float secondInput = 6;
        Assert.assertEquals(30, mainActivity.multiplicationCal(firstInput, secondInput), 0.0001);
    }

    @Test
    public void multiplicationCal2() {
        float firstInput = 5.32f;
        float secondInput = 6.60f;
        Assert.assertEquals(35.112f, mainActivity.multiplicationCal(firstInput, secondInput), 0.0001);
    }
}