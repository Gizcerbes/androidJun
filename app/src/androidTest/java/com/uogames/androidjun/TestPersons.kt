package com.uogames.androidjun

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.uogames.androidjun.database.MyDatabase
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.database.entity.PersonEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class TestPersons {


    lateinit var db: MyDatabase

    @Before
    fun createDB() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(appContext, MyDatabase::class.java).build()
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    private fun setData() = runBlocking {
        db.personDAO().save(PersonEntity(0, "1"))
        db.personDAO().save(PersonEntity(0, "2"))
        db.personDAO().save(PersonEntity(0, "3"))
        db.personDAO().save(PersonEntity(0, "4"))
        db.personDAO().save(PersonEntity(0, "5"))

    }

    @Test
    fun test() = runBlocking {
        setData()

        Assert.assertEquals(db.personDAO().getAll().first().size, 5)
        val flowIdFirst = db.personDAO().getByID(1)
        Assert.assertEquals(flowIdFirst.first()?.personName, "1")
        Assert.assertEquals(db.personDAO().getByID(2).first()?.personName, "2")
        Assert.assertEquals(db.personDAO().getByID(3).first()?.personName, "3")
        Assert.assertEquals(db.personDAO().getByID(4).first()?.personName, "4")
        Assert.assertEquals(db.personDAO().getByID(5).first()?.personName, "5")
        Assert.assertTrue(db.personDAO().save(PersonEntity(1, "my new data")) > 0)
        Assert.assertEquals(flowIdFirst.first()?.personName, "my new data")
        Assert.assertTrue(db.personDAO().delete(PersonEntity(1,"")) > 0)
        Assert.assertEquals(flowIdFirst.first(), null)

    }

}