package dan.jetpack.section4_room_techniques.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dan.jetpack.section4_room_techniques.db.entity.TextEntity

@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData(): List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(
        textEntity: TextEntity
    )

    @Query("DELETE FROM text_table")
    fun deleteAllData()


}