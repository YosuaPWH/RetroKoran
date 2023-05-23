package com.yosuahaloho.retrokoran.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.assertCurrentRouteName
import com.yosuahaloho.retrokoran.onNodeWithStringId
import com.yosuahaloho.retrokoran.ui.navigation.Screen
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Yosua on 24/05/2023
 */
class RetroKoranAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            RetroKoranTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                RetroKoranApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithStringId(R.string.home).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithStringId(R.string.saved).performClick()
        navController.assertCurrentRouteName(Screen.Saved.route)
        composeTestRule.onNodeWithStringId(R.string.about).performClick()
        navController.assertCurrentRouteName(Screen.About.route)
    }

    @Test
    fun navHost_checkSearchIsDisplayed() {
        composeTestRule.onNodeWithText("Search").assertIsDisplayed()
    }

    @Test
    fun navHost_checkIfDataNewsIsDisplayed() {
        composeTestRule.onNodeWithText("NewsList").assertIsDisplayed()
    }
}