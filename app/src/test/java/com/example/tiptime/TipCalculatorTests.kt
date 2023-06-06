package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_10PercentNoRoundup() {
        // arrange
        val amount = 20.0
        val tipPercent = 10.0
        val roundUp = false
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // act
        val calculatedTip = calculateTip(amount, tipPercent, roundUp)

        // assert
        assertEquals(expectedTip, calculatedTip)
    }

    @Test
    fun calculateTip_9PercentWithRoundup() {
        // arrange
        val amount = 20.0
        val tipPercent = 9.0
        val roundUp = true
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // act
        val calculatedTip = calculateTip(amount, tipPercent, roundUp)

        // assert
        assertEquals(expectedTip, calculatedTip)
    }
}