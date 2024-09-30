package com.vezhur.ui.forms

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vezhur.R
import com.vezhur.viewModels.RoomViewModel

@Composable
fun AddRoom(
    moveToAllRooms: () -> Unit
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
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
        OutlinedTextField(
            viewModel.roomTitle,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .testTag("Input field"),
            label = { Text("Name") },
            onValueChange = {viewModel.roomTitle = it})
        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .fillMaxHeight(0.2f)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(40.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "add",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.insertRoom()
                        moveToAllRooms()
                    }
            )
            Text(
                text = "Add",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
