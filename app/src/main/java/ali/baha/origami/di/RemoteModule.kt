package ali.baha.origami.di

import ali.baha.data.remote.RemoteInterface
import ali.baha.data.remote.RemoteService
import ali.baha.data.remote.RemoteServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideApiService(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://piapp.ir/")
        .build()

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit): RemoteInterface {
        return retrofit.create(RemoteInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideApiHelper(remoteServiceImpl: RemoteServiceImpl): RemoteService = remoteServiceImpl
}