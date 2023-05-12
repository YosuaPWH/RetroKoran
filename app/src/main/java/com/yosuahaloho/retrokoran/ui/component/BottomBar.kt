package com.yosuahaloho.retrokoran.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.ui.navigation.BottomBarItem
import com.yosuahaloho.retrokoran.ui.navigation.Screen
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import com.yosuahaloho.retrokoran.ui.theme.backgroundPage
import com.yosuahaloho.retrokoran.ui.theme.selectedBarColor

/**
 * Created by Yosua on 11/05/2023
 */
@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        modifier = modifier
            .background(backgroundPage)
            .border(border = BorderStroke(1.dp, Color.Black)),
    ) {
        val bottomBarItems = listOf(
            BottomBarItem(
                label = "Home",
                icon = R.drawable.ic_bottom_home,
                screen = Screen.Home
            ),
            BottomBarItem(
                label = "Saved",
                icon = R.drawable.ic_bottom_saved,
                screen = Screen.Saved
            ),
            BottomBarItem(
                label = "About",
                icon = R.drawable.ic_bottom_about,
                screen = Screen.About
            )
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomBarItems.map { itemBottomBar ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = itemBottomBar.icon),
                        contentDescription = itemBottomBar.label
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = selectedBarColor
                ),
                selected = currentRoute == itemBottomBar.screen.route,
                onClick = {
                    navController.navigate(itemBottomBar.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}