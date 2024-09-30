package com.vezhur.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vezhur.R
import com.vezhur.data.entities.rooms.AbstractRoom
import com.vezhur.viewModels.RoomViewModel

@Composable
fun RoomCard(
    room: AbstractRoom,
    viewModel: RoomViewModel,
    onNextRoomClicked: (AbstractRoom) -> Unit
) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.15f)
                .clickable {
                    onNextRoomClicked(room)
                },
            contentAlignment = Alignment.Center
        ) {
            Image (
                painter = painterResource(id = R.drawable.room_button),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
            Text(
                modifier = Modifier.fillMaxSize(),
                text = room.title,
                style = TextStyle(fontSize = 40.sp),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.delete),
                contentDescription = "delete",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        viewModel.deleteRoom(room)
                    },
            )
        }
}
