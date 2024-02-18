package dan.jetpack.section4_room_techniques.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dan.jetpack.section4_room_techniques.db.dao.TextDao
import dan.jetpack.section4_room_techniques.db.entity.TextEntity

@Database(
    entities = [TextEntity::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 2, to = 3)
    ]
)
abstract class TextDatabase : RoomDatabase() {

    abstract fun textDao() : TextDao

    companion object {

        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(
            context: Context
        ) : TextDatabase {

            val DB_NAME = "text_database"

            return INSTANCE ?: synchronized(this@Companion) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance

                instance

            }
        }
    }
}