package ali.baha.data.local

import ali.baha.data.model.OrigamiDataModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [OrigamiDataModel::class], version = 1)
abstract class OrigamiDatabase : RoomDatabase() {
    abstract fun getOrigamiDao(): OrigamiDao
}