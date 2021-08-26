package ali.baha.data.local

import ali.baha.data.model.OrigamiDataModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OrigamiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrigami(product: List<OrigamiDataModel>)

    @Query("SELECT * FROM origami_table")
    fun getOrigami(): Flow<List<OrigamiDataModel>>

    @Query("DELETE FROM origami_table")
    suspend fun deleteOrigami()

    @Query("SELECT COUNT(*) FROM origami_table")
    suspend fun sizeOrigami(): Int
}