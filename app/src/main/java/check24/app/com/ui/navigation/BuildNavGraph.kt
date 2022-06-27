package check24.app.com.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import check24.app.com.ui.screens.HomeScreen
import check24.app.com.ui.screens.ItemCategoriesScreen
import check24.app.com.ui.screens.ItemScreen
import check24.app.com.viewmodel.MainViewModel

@Composable
fun BuildNavGraph(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {

        addHomeScreen(navController, this, viewModel)
        addItemCategoriesScreen(navController, this, viewModel)
        addItemScreen(this, viewModel)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToMealCategories = {
                navController.navigate(NavRoute.ItemCategories.path)
            },
            viewModel = viewModel,
        )
    }
}

private fun addItemCategoriesScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.ItemCategories.path) {
        ItemCategoriesScreen(
            navigateToItemScreen = {
                navController.navigate(NavRoute.ItemScreen.path)
            },
            viewModel = viewModel,
        )
    }
}

fun addItemScreen(
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel,
) {
    navGraphBuilder.composable(route = NavRoute.ItemScreen.path) {
        ItemScreen(viewModel)
    }
}
