package com.vezhur

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vezhur.ui.screens.RoomScreen
import com.vezhur.ui.screens.AllRooms
import com.vezhur.ui.forms.AddRoom

enum class SmartHouseScreens(val title: String) {
    AllRooms(title = "All rooms"),
    AddRoom(title = "Add room"),
    RoomScreen(title = "Room screen"),
}


@Composable
fun SmartHouseNavigation(
    navController: NavHostController = rememberNavController()
) {

    Scaffold { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.main_menu),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        NavHost(
            navController = navController,
            startDestination = SmartHouseScreens.AllRooms.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = SmartHouseScreens.AllRooms.name) {
                AllRooms (
                    navController
                )
            }
            composable(route = SmartHouseScreens.AddRoom.name) {
                AddRoom {
                    navController.navigate(SmartHouseScreens.AllRooms.name)
                }
            }
            composable(
                route = SmartHouseScreens.RoomScreen.name + "/{roomId}",
                arguments = listOf(navArgument("roomId") { type = NavType.IntType })
            ) { backStackEntry ->
                val roomId = backStackEntry.arguments?.getInt("roomId")
                RoomScreen(
                    roomId!!
                ) { navController.navigate(SmartHouseScreens.AllRooms.name) }
            }
        }
    }
}