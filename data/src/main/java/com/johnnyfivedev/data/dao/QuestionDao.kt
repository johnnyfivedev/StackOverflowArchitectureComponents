package com.johnnyfivedev.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.johnnyfivedev.data.model.db.QuestionEntity
import com.johnnyfivedev.data.storage.db.Tables
import io.reactivex.Flowable

@Dao
abstract class QuestionDao : BaseDao<QuestionEntity> {

    @Query("SELECT * FROM ${Tables.QUESTION}")
    abstract fun load(): Flowable<List<QuestionEntity>>
}