package com.vezhur

import android.app.Application
import com.vezhur.MainDB

class App : Application() {
    val database by lazy { MainDB.createDataBase(this) }
}