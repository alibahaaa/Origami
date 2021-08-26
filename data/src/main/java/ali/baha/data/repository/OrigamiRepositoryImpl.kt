package ali.baha.data.repository

import ali.baha.data.datasource.OrigamiLocalDataSource
import ali.baha.data.datasource.OrigamiRemoteDataSource
import ali.baha.data.mapper.ModelMapper
import ali.baha.domain.model.OrigamiEntity
import ali.baha.domain.repository.OrigamiRepository
import ali.baha.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class OrigamiRepositoryImpl @Inject constructor(
    private val origamiLocalDataSource: OrigamiLocalDataSource,
    private val origamiRemoteDataSource: OrigamiRemoteDataSource,
    private val modelMapper: ModelMapper
) : OrigamiRepository {
    override suspend fun getOrigamiData(): Flow<DataState<List<OrigamiEntity>>> = flow {
        if (origamiLocalDataSource.sizeOrigami() == 0) {
            emit(DataState.Loading)
        } else {
            origamiLocalDataSource.getOrigamiLocalData().collect {
                emit(DataState.Success(modelMapper.mapFromEntities(it)))
            }
        }
        try {
            val response = origamiRemoteDataSource.getOrigamiRemoteData()
            origamiLocalDataSource.insertOrigami(response?.origamiModelDataModel!!)
            origamiLocalDataSource.getOrigamiLocalData().collect {
                emit(DataState.Success(modelMapper.mapFromEntities(it)))
            }
        } catch (e: Exception) {
                emit(DataState.Error(e))
        }
    }
}