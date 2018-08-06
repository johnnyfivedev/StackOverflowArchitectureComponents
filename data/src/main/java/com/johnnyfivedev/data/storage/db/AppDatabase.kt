package rmr.arch.sample.data.storage.db

import com.johnnyfivedev.data.dao.QuestionDao


interface AppDatabase {

    fun getQuestionDao(): QuestionDao
}