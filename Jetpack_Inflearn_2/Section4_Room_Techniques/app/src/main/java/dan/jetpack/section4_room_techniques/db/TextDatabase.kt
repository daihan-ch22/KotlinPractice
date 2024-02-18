package dan.jetpack.section4_room_techniques.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dan.jetpack.section4_room_techniques.db.dao.TextDao
import dan.jetpack.section4_room_techniques.db.dao.TextDao2
import dan.jetpack.section4_room_techniques.db.entity.TextEntity
import dan.jetpack.section4_room_techniques.db.entity.TextEntity2

@Database(
    entities = [TextEntity::class, TextEntity2::class],
    version = 3
)
abstract class TextDatabase : RoomDatabase() {

    abstract fun textDao() : TextDao
    abstract fun textDao2() : TextDao2

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
                )
                    //.fallbackToDestructiveMigration() // 데이터 구조 변경 시 이전 버전의 db 내용 날아감. (매우 주의)
                    .addMigrations(MIGRATION_1_2)
                    .addMigrations(MIGRATION_2_3)
                    .build()

                INSTANCE = instance

                instance

            }
        }

        private val MIGRATION_1_2 = object : Migration(1,2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE `text_table2` " +
                        "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `text2` TEXT NOT NULL)")
            }
        }

        private val MIGRATION_2_3 = object : Migration(2,3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `text_table2` ADD COLUMN `newText` " +
                        "TEXT NOT NULL DEFAULT `newnew`")
            }
        }

    }
}