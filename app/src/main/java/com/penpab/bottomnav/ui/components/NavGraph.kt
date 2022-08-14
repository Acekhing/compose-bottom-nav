package com.penpab.bottomnav.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.penpab.bottomnav.ui.screens.FavouriteScreen
import com.penpab.bottomnav.ui.screens.HomeScreen
import com.penpab.bottomnav.ui.screens.ProfileScreen
import com.penpab.bottomnav.ui.screens.SearchScreen
import com.penpab.bottomnav.ui.utils.BottomNavUtils

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavUtils.NavItem.Home.route) {
        composable(route = BottomNavUtils.NavItem.Home.route){ HomeScreen()}
        composable(route = BottomNavUtils.NavItem.Search.route){ SearchScreen()}
        composable(route = BottomNavUtils.NavItem.Favourite.route){ FavouriteScreen()}
        composable(route = BottomNavUtils.NavItem.Profile.route){ ProfileScreen()}
    }
}