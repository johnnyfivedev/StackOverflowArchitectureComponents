package rmr.arch.sample.data.storage.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.johnnyfivedev.data.dao.QuestionDao
import com.johnnyfivedev.data.model.db.QuestionEntity

@Database(entities = [
    QuestionEntity::class
], version = 1)
abstract class AppDatabaseImpl : RoomDatabase(), AppDatabase {

    companion object {
        const val NAME = "stackoverflowarchdb"
    }

    abstract override fun getQuestionDao(): QuestionDao
}