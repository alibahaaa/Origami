package ali.baha.origami.home.ui

import ali.baha.origami.home.ui.home.HomeScreenBody
import ali.baha.origami.home.utils.ViewState
import ali.baha.origami.uikit.*
import ali.baha.origami.home.viewmodel.OrigamiHomeViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    origamiHomeViewModel: OrigamiHomeViewModel = viewModel()
) {
    val origamiData = origamiHomeViewModel
        .getOrigamiData()
        .collectAsState(initial = ViewState.Loading)
        .value

    when (origamiData) {
        is ViewState.Empty -> EmptyBody()
        is ViewState.Error -> ErrorBody()
        is ViewState.Loading -> LoadingBody()
        is ViewState.Success -> HomeScreenBody(
            navController = navController,
            data = origamiData.data
        )
    }

}



