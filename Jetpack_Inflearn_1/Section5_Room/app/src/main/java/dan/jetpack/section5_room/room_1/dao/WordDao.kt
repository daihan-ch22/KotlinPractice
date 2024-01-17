package dan.jetpack.section5_room.room_1.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()
}