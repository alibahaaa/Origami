package ali.baha.data.datasource

import ali.baha.data.model.OrigamiDataModel
import kotlinx.coroutines.flow.Flow

interface OrigamiLocalDataSource {
    suspend fun getOrigamiLocalData() : Flow<List<OrigamiDataModel>>

    suspend fun insertOrigami(origamiDataModel: List<OrigamiDataModel>)

    suspend fun sizeOrigami(): Int
}