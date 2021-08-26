package ali.baha.data.datasource

import ali.baha.data.local.OrigamiDao
import ali.baha.data.model.OrigamiDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrigamiLocalDataSourceImpl @Inject constructor(
    private val origamiDao: OrigamiDao
) : OrigamiLocalDataSource {
    override suspend fun getOrigamiLocalData(): Flow<List<OrigamiDataModel>> =
        origamiDao.getOrigami()

    override suspend fun insertOrigami(origamiDataModel: List<OrigamiDataModel>) {
        origamiDao.deleteOrigami()
        origamiDao.insertOrigami(origamiDataModel)
    }

    override suspend fun sizeOrigami(): Int {
        return origamiDao.sizeOrigami()
    }
}