package com.example.busschedule

import android.app.Application
import com.example.busschedule.database.AppDataBase

class BusScheduleApplication: Application() {
    val database: AppDataBase by lazy {
        AppDataBase.getDatabase(this)
    }
}