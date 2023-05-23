package com.yosuahaloho.retrokoran

import androidx.navigation.NavController
import org.junit.Assert

/**
 * Created by Yosua on 11/05/2023
 */
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    Assert.assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}