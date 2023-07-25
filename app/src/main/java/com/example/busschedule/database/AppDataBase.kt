package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao


@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context):AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
