package ali.baha.data.datasource

import ali.baha.data.model.OrigamiRemoteModel

interface OrigamiRemoteDataSource {
    suspend fun getOrigamiRemoteData() : OrigamiRemoteModel?
}