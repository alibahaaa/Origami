package ali.baha.origami.di

import ali.baha.data.datasource.OrigamiRemoteDataSource
import ali.baha.data.datasource.OrigamiRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideOrigamiRemoteDataSource(
        origamiRemoteDataSourceImpl: OrigamiRemoteDataSourceImpl
    ): OrigamiRemoteDataSource = origamiRemoteDataSourceImpl
}