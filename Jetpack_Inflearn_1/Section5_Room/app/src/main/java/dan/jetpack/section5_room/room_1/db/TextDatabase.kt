package dan.jetpack.section5_room.room_1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dan.jetpack.section5_room.room_1.dao.TextDao
import dan.jetpack.section5_room.room_1.dao.WordDao
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity

@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class TextDatabase: RoomDatabase() {

    abstract fun textDao(): TextDao
    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: TextDatabase? = null

        fun getDatabase(
            context: Context
        ) : TextDatabase {

            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}