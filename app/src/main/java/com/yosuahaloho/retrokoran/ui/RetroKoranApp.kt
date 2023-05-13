package com.yosuahaloho.retrokoran.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yosuahaloho.retrokoran.ui.component.BottomBar
import com.yosuahaloho.retrokoran.ui.navigation.Screen
import com.yosuahaloho.retrokoran.ui.page.about.AboutScreen
import com.yosuahaloho.retrokoran.ui.page.home.HomeScreen
import com.yosuahaloho.retrokoran.ui.page.saved.SavedScreen
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme

/**
 * Created by Yosua on 11/05/2023
 */
@Composable
fun RetroKoranApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Saved.route) {
                SavedScreen()
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RetroKoranPreview() {
    RetroKoranTheme {
        RetroKoranApp()
    }
}