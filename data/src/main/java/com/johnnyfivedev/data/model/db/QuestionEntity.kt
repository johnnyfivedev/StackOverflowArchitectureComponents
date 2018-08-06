package com.johnnyfivedev.data.model.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.johnnyfivedev.data.storage.db.Tables

@Entity(tableName = Tables.QUESTION)
class QuestionEntity(

    @PrimaryKey
    val id: Long,

    val title: String
)