package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        // arrange
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // act
//        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithTag(TEST_TAG_BILL_AMOUNT).performTextInput("10")
        composeTestRule.onNodeWithTag(TEST_TAG_PERCENTAGE).performTextInput("20")

        // assert
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists("error")
    }
}