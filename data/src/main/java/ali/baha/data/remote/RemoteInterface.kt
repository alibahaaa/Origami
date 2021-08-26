package ali.baha.data.remote

import ali.baha.data.model.OrigamiRemoteModel
import retrofit2.http.GET

interface RemoteInterface {
    @GET("origamiData.php")
    suspend fun getOrigamiRemote(): OrigamiRemoteModel?
}