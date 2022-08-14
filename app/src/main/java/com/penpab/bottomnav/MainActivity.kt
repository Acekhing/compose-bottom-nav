package com.penpab.bottomnav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.penpab.bottomnav.ui.components.BottomNav
import com.penpab.bottomnav.ui.components.NavGraph
import com.penpab.bottomnav.ui.theme.BottomNavTheme
import com.penpab.bottomnav.ui.utils.BottomNavUtils

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavTheme {
                val navController = rememberNavController()
                Scaffold(
                    backgroundColor = Color(0XFFE5E5E5),
                    bottomBar = { BottomNav(navController) },
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun Preview() {
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = Color(0XFFE5E5E5),
        bottomBar = { BottomNav(navController) },
        modifier = Modifier.fillMaxSize()
    ) {
        NavGraph(navController = navController)
    }
}