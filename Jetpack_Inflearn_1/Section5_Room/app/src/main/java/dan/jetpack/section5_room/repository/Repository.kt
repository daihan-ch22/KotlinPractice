package dan.jetpack.section5_room.repository

import android.content.Context
import dan.jetpack.section5_room.room_1.db.TextDatabase
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity

class Repository(
    context: Context
) {

    private val db = TextDatabase.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextData(text: String) = db.textDao().insert(TextEntity(0,text))
    fun insertWordData(text: String) = db.wordDao().insert(WordEntity(0,text))

    fun deleteTextData() = db.textDao().deleteAllData()
    fun deleteWordData() = db.wordDao().deleteAllData()
}