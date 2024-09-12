package gregorydhm.ccm2FirstApp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gregorydhm.ccm2FirstApp.ui.screen.F1DriversScreen
import gregorydhm.ccm2FirstApp.ui.screen.ListScreen
import gregorydhm.ccm2FirstApp.ui.screen.MainScreen
import gregorydhm.ccm2FirstApp.ui.screen.PersonScreen
import gregorydhm.ccm2FirstApp.ui.screen.QuoteScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val F1_DRIVERS_SCREEN = "f1_drivers_screen"
    const val QUOTE_SCREEN = "quote_screen"
    const val PERSON_SCREEN = "person_screen"
}

fun NavGraphBuilder.addPersonScreenNavigation() {
    composable(
        route = NavigationPath.PERSON_SCREEN,
    ) {
        PersonScreen()
    }
}


fun NavGraphBuilder.addQuoteScreenNavigation() {
    composable(
        route = NavigationPath.QUOTE_SCREEN,
    ) {
        QuoteScreen()
    }
}


fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onF1DriversClick: () -> Unit,
    onQuoteClick: () -> Unit,
    onPersonClick: () -> Unit,
) {
    composable(
        route = gregorydhm.ccm2FirstApp.ui.navigation.NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = { onButtonClick() },
            onF1DriversClick = { onF1DriversClick() } ,
            onQuoteClick = {onQuoteClick()},
            onPersonClick = {onPersonClick()}
        )
    }
}


fun NavGraphBuilder.addListScreenNavigation(navController: NavController) {
    composable(
        route = gregorydhm.ccm2FirstApp.ui.navigation.NavigationPath.LIST_SCREEN,
    ) {
        ListScreen(navController)
    }
}

fun NavGraphBuilder.addF1DriversScreenNavigation(navController: NavController) {
    composable(
        route = gregorydhm.ccm2FirstApp.ui.navigation.NavigationPath.F1_DRIVERS_SCREEN,
    ) {
        // Appel à ton composable F1DriversScreen
        F1DriversScreen(navController)
    }
}

@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = {
                navController.navigate(NavigationPath.LIST_SCREEN)
            },
            onF1DriversClick = {
                navController.navigate(NavigationPath.F1_DRIVERS_SCREEN)
            },
            onQuoteClick = {
                navController.navigate(NavigationPath.QUOTE_SCREEN)
            },
            onPersonClick = {
                navController.navigate(NavigationPath.PERSON_SCREEN)
            }
        )
        addListScreenNavigation(navController = navController)
        addF1DriversScreenNavigation(navController = navController)
        addQuoteScreenNavigation()
        addPersonScreenNavigation()
    }
}
