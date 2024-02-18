package dan.jetpack.section4_room_techniques.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table")
data class TextEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Long,

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "text2", defaultValue = "this is text2 default")
    val text2: String

)