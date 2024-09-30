package com.vezhur.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.vezhur.App
import com.vezhur.data.dao.RoomDao
import com.vezhur.data.entities.rooms.AbstractRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RoomViewModel(private val dao: RoomDao) : ViewModel()  {

    var roomTitle by mutableStateOf("")
    var roomTemperature by mutableFloatStateOf(0f)
    var roomHumidityPercentage by mutableFloatStateOf(0f)
    var roomLightningPercentage by mutableFloatStateOf(0f)
    var roomTargetTemperature by mutableFloatStateOf(0f)
    var roomConditioning by mutableStateOf(false)

    var roomsList = mutableStateOf<List<AbstractRoom>>(emptyList())

    val currentRoom = mutableStateOf(AbstractRoom())

    init {
        getAll()
    }

    fun conditioning() {
        viewModelScope.launch(Dispatchers.IO) {
            while(true) {
                if (currentRoom.value.id != null) {
                    if (currentRoom.value.targetTemperature > currentRoom.value.temperature + 0.5) {
                        currentRoom.value.temperature += 1
                        updateTemperature()
                    } else if (currentRoom.value.targetTemperature <= currentRoom.value.temperature - 0.5) {
                        currentRoom.value.temperature -= 1
                        updateTemperature()
                    }
                }
                if (!roomConditioning) {
                    break
                }
                delay(2000)
            }
        }
    }

    fun updateConditioning(conditioning: Boolean) {
        this.roomConditioning = conditioning
    }

    fun getById(id: Int) {
        viewModelScope.launch {
            dao.getById(id).collect { data ->
                currentRoom.value = data
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            dao.getAll().collect { data ->
                roomsList.value = data
            }
        }
    }

    fun updateLightning(value: Float) = viewModelScope.launch(Dispatchers.IO) {
        currentRoom.value.lightningPercentage = value
        dao.updateAll(
            currentRoom.value
        )
    }

    fun updateTargetTemperature(value: Float) = viewModelScope.launch(Dispatchers.IO) {
        currentRoom.value.targetTemperature = value
        dao.updateAll(
            currentRoom.value
        )
    }

    fun updateTemperature() = viewModelScope.launch(Dispatchers.IO) {
        dao.updateTemperature(
            currentRoom.value.id!!,
            currentRoom.value.temperature
        )
    }

    fun insertRoom() = viewModelScope.launch(Dispatchers.IO) {
        dao.insertAll(
            AbstractRoom(title = roomTitle, temperature = roomTemperature, targetTemperature = roomTargetTemperature, humidityPercentage = roomHumidityPercentage,
                lightningPercentage = roomLightningPercentage)
        )
    }

    fun deleteRoom(room: AbstractRoom) = viewModelScope.launch(Dispatchers.IO) {
        dao.deleteById(
            room.id!!
        )
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                val roomDao = database.dao
                return RoomViewModel(roomDao) as T
            }
        }
    }
}
