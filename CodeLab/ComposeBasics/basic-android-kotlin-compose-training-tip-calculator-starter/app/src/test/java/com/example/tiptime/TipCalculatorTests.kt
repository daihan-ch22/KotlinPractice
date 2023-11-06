package com.example.tiptime

import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculatorTip_20PercentNoRoundup(){
        val amount = 10.00
        val tipPercentage = 20.00

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercentage, false)

        //check if expectedTip == actualTip
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculatorTip_negativePercentage(){
        val amount = 10.00
        val tipPercentage = -20.00

        val actualTip = calculateTip(amount, tipPercentage, false)

        assertEquals("NEGATIVE_RESULT", actualTip)
    }
}