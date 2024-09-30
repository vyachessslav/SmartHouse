package com.vezhur.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vezhur.R
import com.vezhur.data.entities.rooms.AbstractRoom
import com.vezhur.viewModels.RoomViewModel


@Composable
fun LightingCard(
    viewModel: RoomViewModel,
    currRoom: AbstractRoom
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3B95B)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.light),
                    contentDescription = "light",
                    modifier = Modifier
                        .weight(2f)
                        .size(32.dp)
                )
                Text(
                    text = "Light",
                    modifier = Modifier
                        .weight(5f),
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.DarkGray
                )
                var switchValue by remember { mutableStateOf(true) }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .weight(7f, true)
                ) {
                    Switch(
                        checked = switchValue,
                        onCheckedChange = { switchValue = it },
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .testTag("Lightning switch")
                    )
                }

            }

            var sliderValue = currRoom.lightningPercentage

            LaunchedEffect(currRoom.lightningPercentage) {
                sliderValue = currRoom.lightningPercentage
            }
            Text(
                text = sliderValue.toInt().toString() + " %",
                style = TextStyle(fontSize = 20.sp),
                color = Color.DarkGray
            )
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f,
                steps = 100,
                onValueChangeFinished = {viewModel.updateLightning(sliderValue)},
                modifier = Modifier
                    .width(250.dp),
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFF3B95B),
                    activeTrackColor = Color(0xFFF3B95B),
                    inactiveTrackColor = Color.Gray,
                ),
            )
        }
    }
}
