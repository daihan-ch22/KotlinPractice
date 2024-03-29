package dan.jetpack.section2_room_coroutineflow.room_flow_listadapter.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "age")
    var age : Int
)