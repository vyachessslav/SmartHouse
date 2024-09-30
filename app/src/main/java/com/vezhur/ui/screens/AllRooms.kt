package com.vezhur.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vezhur.viewModels.RoomViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vezhur.R
import com.vezhur.SmartHouseScreens
import com.vezhur.ui.cards.RoomCard

@Composable
fun AllRooms(
    navController: NavController
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    val itemsList = viewModel.roomsList.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "SmartHouse",
                style = TextStyle(fontSize = 60.sp),
                color = Color.Green,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.add_button),
                contentDescription = "Add new room",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        navController.navigate(SmartHouseScreens.AddRoom.name)
                    }
                    .testTag("Add button")
            )
        }
        Column {
            if (itemsList.isNotEmpty()) {
                for (item in itemsList) {
                    RoomCard(item, viewModel) {
                        navController.navigate((SmartHouseScreens.RoomScreen.name) + "/${item.id}")
                    }
                }
            }
        }
    }

}
