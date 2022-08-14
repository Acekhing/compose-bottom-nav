package com.penpab.bottomnav.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.penpab.bottomnav.R

object BottomNavUtils {

    sealed class NavItem(
        val route: String,
        @StringRes val label: Int,
        @DrawableRes val icon: Int
    ) {
        object Home: NavItem("home", R.string.home, R.drawable.ic_home)
        object Search: NavItem("search", R.string.search, R.drawable.ic_search)
        object Favourite: NavItem("favourite", R.string.favourite, R.drawable.ic_fav)
        object Profile: NavItem("profile", R.string.profile, R.drawable.ic_person)
    }

}