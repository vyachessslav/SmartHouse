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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vezhur.R
import com.vezhur.data.entities.rooms.AbstractRoom
import com.vezhur.viewModels.RoomViewModel
import java.util.Timer
import java.util.TimerTask


@Composable
fun ConditionCard(
    viewModel: RoomViewModel,
    currRoom: AbstractRoom
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f),
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
                    .padding(top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cond),
                    contentDescription = "Air conditioning",
                    modifier = Modifier
                        .weight(2f)
                        .size(32.dp)
                )
                Text(
                    text = "Conditioner temperature",
                    modifier = Modifier
                        .weight(5f),
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.DarkGray
                )

                var switchValue by remember { mutableStateOf(false) }
                viewModel.roomConditioning = switchValue

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .weight(6f, true)
                ) {
                    Switch(
                        checked = switchValue,
                        onCheckedChange = {
                            switchValue = it
                            viewModel.updateConditioning(switchValue)
                            if (switchValue) {
                                viewModel.conditioning()
                            }},
                        modifier = Modifier
                            .padding(end = 16.dp)
                    )
                }
            }

            var sliderValue = currRoom.targetTemperature

            LaunchedEffect(currRoom.targetTemperature) {
                sliderValue = currRoom.targetTemperature
            }

            Text(
                text = sliderValue.toString() + " ºC",
                style = TextStyle(fontSize = 20.sp),
                color = Color.DarkGray
            )
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 15f..32f,
                steps = 16,
                onValueChangeFinished = {viewModel.updateTargetTemperature(sliderValue)},
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
