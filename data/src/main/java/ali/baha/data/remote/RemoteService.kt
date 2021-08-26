package ali.baha.data.remote

import ali.baha.data.model.OrigamiRemoteModel

interface RemoteService {
    suspend fun getOrigamiRemote() : OrigamiRemoteModel?
}