package ali.baha.origami.uikit

import ali.baha.origami.R
import ali.baha.origami.app.routers.Screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBarView(title: String, topBarType: TopBarType, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(12.dp, 0.dp, 12.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        TextView(text = title)
        Image(
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .clickable {
                    when (topBarType) {
                        TopBarType.Home -> navController.navigate(Screen.MenuScreen.route)
                        TopBarType.Detail -> navController.popBackStack()
                        TopBarType.Menu -> navController.popBackStack()
                    }
                },
            painter = painterResource(
                id = when (topBarType) {
                    TopBarType.Home -> R.drawable.menu
                    TopBarType.Detail -> R.drawable.back
                    TopBarType.Menu -> R.drawable.back
                }
            ),
            contentDescription = "Top Bar Image",
        )
    }
}

enum class TopBarType {
    Home, Detail, Menu
}