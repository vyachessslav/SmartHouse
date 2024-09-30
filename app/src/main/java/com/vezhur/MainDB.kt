package com.vezhur

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.room.RoomDatabase
import com.vezhur.data.dao.RoomDao
import com.vezhur.data.entities.rooms.AbstractRoom


@Database(
    entities = [
        AbstractRoom::class
    ],
    version = 2, exportSchema = false
)
abstract class MainDB : RoomDatabase() {
    abstract val dao: RoomDao

    companion object{
        fun createDataBase(context: Context): MainDB{
            return databaseBuilder(
                context,
                MainDB::class.java,
                "smart_home")
                .fallbackToDestructiveMigration()
                .build()
            /*return inMemoryDatabaseBuilder(
                context,
                MainDB::class.java)
                .build()*/
        }
    }
}
