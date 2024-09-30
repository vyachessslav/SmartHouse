package com.vezhur.ui.elems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vezhur.R

@Preview(showBackground = true)
@Composable
fun PlayerElem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.previous),
            contentDescription = "previous",
            Modifier
                .size(32.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.play),
            contentDescription = "curr",
            Modifier
                .size(32.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.next),
            contentDescription = "next",
            Modifier
                .size(32.dp)
        )
    }
}