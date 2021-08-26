package ali.baha.origami.di

import ali.baha.data.datasource.OrigamiLocalDataSource
import ali.baha.data.datasource.OrigamiLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideOrigamiRemoteDataSource(
        origamiLocalDataSourceImpl: OrigamiLocalDataSourceImpl
    ): OrigamiLocalDataSource = origamiLocalDataSourceImpl
}