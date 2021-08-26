package ali.baha.origami.di

import ali.baha.data.repository.OrigamiRepositoryImpl
import ali.baha.domain.repository.OrigamiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrigamiRepositoryModule {
    @Singleton
    @Provides
    fun provideOrigamiRepository(
        origamiRepositoryImpl: OrigamiRepositoryImpl
    ): OrigamiRepository = origamiRepositoryImpl
}