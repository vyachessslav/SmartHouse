package com.vezhur.ui.elems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vezhur.R

@Preview(showBackground = true)
@Composable
fun TrackElem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.recovery_album),
            contentDescription = "image",
            modifier = Modifier
                .size(40.dp)
        )
        Column(
        ) {
            Text(text = "Not Afraid")
            Text(
                text = "Eminem",
                style = TextStyle(fontSize = 12.sp),
                color = Color.DarkGray
            )
        }

    }
}