package ali.baha.domain.repository

import ali.baha.domain.model.OrigamiEntity
import ali.baha.domain.utils.DataState
import kotlinx.coroutines.flow.Flow

interface OrigamiRepository {
    suspend fun getOrigamiData() : Flow<DataState<List<OrigamiEntity>>>
}