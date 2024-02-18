package dan.jetpack.section4_room_techniques.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dan.jetpack.section4_room_techniques.db.entity.TextEntity
import dan.jetpack.section4_room_techniques.db.entity.TextEntity2

@Dao
interface TextDao2 {

    @Query("SELECT * FROM text_table2")
    fun getAllData(): List<TextEntity2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(
        textEntity: TextEntity2
    )

    @Query("DELETE FROM text_table2")
    fun deleteAllData()


}