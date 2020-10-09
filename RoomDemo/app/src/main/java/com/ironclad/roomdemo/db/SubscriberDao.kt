package com.ironclad.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDao {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM SUBSCRIBER_DATA_TABLE")
    suspend fun deleteAll()

    @Query("SELECT * FROM SUBSCRIBER_DATA_TABLE")
    fun getAllSubscribers(): LiveData<List<Subscriber>>
}