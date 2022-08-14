package com.penpab.bottomnav.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.penpab.bottomnav.ui.utils.BottomNavUtils

@Composable
fun BottomNav(navController: NavController) {

    val navItems = listOf(
        BottomNavUtils.NavItem.Home,
        BottomNavUtils.NavItem.Search,
        BottomNavUtils.NavItem.Favourite,
        BottomNavUtils.NavItem.Profile,
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Magenta
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                alwaysShowLabel = currentRoute == navItem.route,
                icon = {
                    Icon(
                        painterResource(
                            id = navItem.icon),
                        contentDescription = stringResource(id = navItem.label)
                    )
                },
                label = {
                        Text(text = stringResource(id = navItem.label))
                },
                selectedContentColor = Color.Magenta,
                onClick = {
                    navController.navigate(navItem.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
