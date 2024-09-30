package com.vezhur.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vezhur.R
import com.vezhur.data.entities.rooms.AbstractRoom
import com.vezhur.viewModels.RoomViewModel

@Composable
fun MainCard(
    viewModel: RoomViewModel,
    currRoom: AbstractRoom
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEFCB6B)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = currRoom.title,
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 16.dp
                ),
                style = TextStyle(fontSize = 32.sp),
                color = Color.DarkGray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Temperature",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.DarkGray
                )
                Text(
                    text = "Humidity",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.DarkGray
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = currRoom.temperature.toString() + "ºC",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
                Text(
                    text = currRoom.humidityPercentage.toString() + "%",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
            }
        }
    }
}

