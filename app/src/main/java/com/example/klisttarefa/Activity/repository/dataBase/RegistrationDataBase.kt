package com.example.klisttarefa.Activity.repository.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.klisttarefa.Activity.repository.dao.RegistrationDao
import com.example.klisttarefa.Activity.repository.model.Registration

@Database(
    entities = [Registration::class],
    version = 1,
    exportSchema = false
)
abstract class RegistrationDataBase : RoomDatabase() {

    abstract val registrationDao: RegistrationDao

    companion object {

        @Volatile
        private var INSTANCE: RegistrationDataBase? = null
        fun getInstance(context: Context): RegistrationDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegistrationDataBase::class.java,
                        "regist_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}