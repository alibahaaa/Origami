package ali.baha.origami.di

import ali.baha.data.local.OrigamiDao
import ali.baha.data.local.OrigamiDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): OrigamiDatabase =
        Room.databaseBuilder(
            context,
            OrigamiDatabase::class.java,
            "origami_db"
        ).build()


    @Provides
    fun provideOrigamiDao(origamiDatabase: OrigamiDatabase): OrigamiDao {
        return origamiDatabase.getOrigamiDao()
    }
}