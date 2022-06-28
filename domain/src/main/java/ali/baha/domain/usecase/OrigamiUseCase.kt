package ali.baha.domain.usecase

import ali.baha.domain.model.OrigamiEntity
import ali.baha.domain.repository.OrigamiRepository
import ali.baha.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrigamiUseCase @Inject constructor(private val origamiRepository: OrigamiRepository) {
    suspend fun getOrigamiData(): Flow<DataState<List<OrigamiEntity>>> =
        origamiRepository.getOrigamiData()
}
