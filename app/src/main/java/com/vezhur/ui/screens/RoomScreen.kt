package com.vezhur.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vezhur.R
import com.vezhur.ui.cards.LightingCard
import com.vezhur.ui.cards.MainCard
import com.vezhur.ui.cards.ConditionCard
import com.vezhur.ui.cards.MusicCard
import com.vezhur.viewModels.RoomViewModel

@Composable
fun RoomScreen(
    roomId: Int,
    moveToAllRooms: () -> Unit,
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    viewModel.getById(roomId)
    val currRoom = viewModel.currentRoom.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        MainCard(viewModel, currRoom)
        LightingCard(viewModel, currRoom)
        ConditionCard(viewModel, currRoom)
        MusicCard()
    }

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "back",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable {
                    moveToAllRooms()
                }
        )
    }
}
