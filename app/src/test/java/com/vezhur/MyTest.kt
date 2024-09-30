package com.vezhur

import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MyTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun addingRoomAndLightningTest() {
        rule.setContent { SmartHouseNavigation() }
        rule.onNodeWithContentDescription("Add new room").performClick()
        rule.onNodeWithTag("Input field").performTextInput("Bedroom")
        rule.onNodeWithContentDescription("add").performClick()
        rule.onNodeWithText("Bedroom").assertExists()
        rule.onNodeWithText("Bedroom").performClick()
        rule.onNodeWithTag("Lightning switch").performClick()
        rule.onNodeWithTag("Lightning switch").assertIsOff()
        rule.onNodeWithTag("Lightning switch").performClick()
        rule.onNodeWithTag("Lightning switch").assertIsOn()
    }
}
