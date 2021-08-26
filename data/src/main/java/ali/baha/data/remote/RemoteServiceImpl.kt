package ali.baha.data.remote

import ali.baha.data.model.OrigamiRemoteModel
import javax.inject.Inject

class RemoteServiceImpl @Inject constructor(
    private val remoteInterface: RemoteInterface
) : RemoteService {
    override suspend fun getOrigamiRemote(): OrigamiRemoteModel? =
        remoteInterface.getOrigamiRemote()
}