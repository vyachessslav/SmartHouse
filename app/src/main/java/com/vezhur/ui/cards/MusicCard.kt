package com.vezhur.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import com.vezhur.R
import com.vezhur.ui.elems.PlayerElem
import com.vezhur.ui.elems.TrackElem

@Preview(showBackground = true)
@Composable
fun MusicCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3B95B)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
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
                    painter = painterResource(id = R.drawable.music),
                    contentDescription = "note",
                    modifier = Modifier
                        .weight(2f)
                        .size(32.dp)
                )
                Text(
                    text = "Музыка",
                    modifier = Modifier
                        .weight(4f),
                    style = TextStyle(fontSize = 20.sp),
                )
                Spacer(
                    modifier = Modifier
                    .weight(6f),
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            )
            {
                TrackElem()
                PlayerElem()
            }

            var sliderValue by remember { mutableFloatStateOf(0f) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.volume_mute),
                    contentDescription = "volume",
                    Modifier
                        .size(24.dp),
                )
                Slider(
                    value = sliderValue,
                    onValueChange = { sliderValue = it },
                    valueRange = 0f..100f,
                    steps = 100,
                    modifier = Modifier
                        .width(250.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFF3B95B),
                        activeTrackColor = Color(0xFFF3B95B),
                        inactiveTrackColor = Color.Gray,
                    ),
                )
                Image(
                    painter = painterResource(id = R.drawable.volume_high),
                    contentDescription = "next",
                    Modifier
                        .size(24.dp)
                )
            }

        }
    }

}