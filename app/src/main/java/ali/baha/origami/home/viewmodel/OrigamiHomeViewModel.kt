package ali.baha.origami.home.viewmodel

import ali.baha.domain.model.OrigamiEntity
import ali.baha.domain.usecase.OrigamiUseCase
import ali.baha.domain.utils.DataState
import ali.baha.origami.home.utils.ViewState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class OrigamiHomeViewModel @Inject constructor(
    private val origamiUseCase: OrigamiUseCase
) : ViewModel() {
    fun getOrigamiData(): Flow<ViewState<List<OrigamiEntity>>> = flow {
        origamiUseCase.getOrigamiData()
            .catch { println(it.message) }
            .collect {
                when (it) {
                    is DataState.Error -> emit(ViewState.Error(it.exception))
                    is DataState.Loading -> emit(ViewState.Loading)
                    is DataState.Success -> {
                        if (it.data.isEmpty())
                            emit(ViewState.Empty)
                        else
                            emit(ViewState.Success(it.data))
                    }
                }
            }
    }
}