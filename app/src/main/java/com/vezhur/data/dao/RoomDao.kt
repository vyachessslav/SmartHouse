package com.vezhur.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import androidx.room.Update
import com.vezhur.data.entities.rooms.AbstractRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM rooms")
    fun getAll(): Flow<List<AbstractRoom>>

    @Query("SELECT * FROM rooms WHERE id = :roomId")
    fun getById(roomId: Int): Flow<AbstractRoom>

//    @Query("SELECT * FROM rooms WHERE id IN (:roomsIds)")
//    suspend fun getAllByIds(roomsIds: IntArray): List<AbstractRoom>
//
//    @Query(
//        "SELECT * FROM rooms " +
//        "JOIN air_conditioners ON rooms.id = air_conditioners.room_id"
//    )
//    suspend fun loadRoomAndAllAirConditioners(): Map<AbstractRoom, List<AirConditioner>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg rooms: AbstractRoom)

    @Update
    suspend fun updateAll(vararg rooms: AbstractRoom)

    @Query("UPDATE rooms SET temperature = :temperature WHERE id = :roomId")
    suspend fun updateTemperature(roomId: Int, temperature: Float)

    @Query("DELETE FROM rooms WHERE id == :roomId")
    suspend fun deleteById(roomId: Int)

}
