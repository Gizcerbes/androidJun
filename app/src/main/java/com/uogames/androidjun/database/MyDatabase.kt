package com.uogames.androidjun.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uogames.androidjun.database.dao.PersonDAO
import com.uogames.androidjun.database.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

	companion object {
		private var INSTANCE: MyDatabase? = null

		fun get(context: Context): MyDatabase {
			if (INSTANCE == null) {
				INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "database").build()
			}
			return INSTANCE as MyDatabase
		}
	}

	abstract fun personDAO(): PersonDAO

}