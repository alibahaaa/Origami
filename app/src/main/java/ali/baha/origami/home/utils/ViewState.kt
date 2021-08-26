package ali.baha.origami.home.utils

sealed class ViewState<out R> {
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Error(val exception: Exception) : ViewState<Nothing>()
    object Loading : ViewState<Nothing>()
    object Empty : ViewState<Nothing>()
}