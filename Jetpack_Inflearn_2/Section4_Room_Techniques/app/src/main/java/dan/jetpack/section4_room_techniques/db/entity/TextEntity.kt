package dan.jetpack.section4_room_techniques.db.entity

import android.provider.ContactsContract.Data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.Date

@Entity(tableName = "text_table")
data class TextEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Long,

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "text2", defaultValue = "this is text2 default")
    val text2: String,

    @ColumnInfo(name = "currentDate", defaultValue = "d")
    val currentDate : Date

)

class MyConverters {

    @TypeConverter
    fun fromTimestampToData(
        value : Long
    ) : Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToTimestamp(
        date: Date
    ) : Long {
        return date.time
    }
}