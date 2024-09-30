package com.vezhur.data.entities.rooms

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
class AbstractRoom(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "temperature") var temperature: Float = 0f,
    @ColumnInfo(name = "humidity_percentage") var humidityPercentage: Float = 0f,
    @ColumnInfo(name = "lightning_percentage") var lightningPercentage: Float = 0f,
    @ColumnInfo(name = "target_temperature") var targetTemperature: Float = 0f,
)
