package ali.baha.origami.home.ui.home

import ali.baha.domain.model.OrigamiEntity
import ali.baha.origami.uikit.TopBarType
import ali.baha.origami.uikit.TopBarView
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreenBody(navController: NavController, data: List<OrigamiEntity>) {
    Scaffold(
        topBar = {
            TopBarView(
                title = "هنر کاغذ و تا",
                topBarType = TopBarType.Home,
                navController = navController
            )
        },
    ) {
        HomeScreenDataView(navController = navController, data = data)
    }
}

