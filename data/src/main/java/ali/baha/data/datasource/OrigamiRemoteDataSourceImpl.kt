package ali.baha.data.datasource

import ali.baha.data.model.OrigamiRemoteModel
import ali.baha.data.remote.RemoteService
import javax.inject.Inject

class OrigamiRemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService
) : OrigamiRemoteDataSource {
    override suspend fun getOrigamiRemoteData(): OrigamiRemoteModel? =
        remoteService.getOrigamiRemote()
}