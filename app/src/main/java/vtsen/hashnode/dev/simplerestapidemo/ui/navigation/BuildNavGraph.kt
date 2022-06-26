package vtsen.hashnode.dev.simplerestapidemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vtsen.hashnode.dev.simplerestapidemo.ui.screens.HomeScreen
import vtsen.hashnode.dev.simplerestapidemo.ui.screens.ItemCategoriesScreen
import vtsen.hashnode.dev.simplerestapidemo.viewmodel.MainViewModel

@Composable
fun BuildNavGraph(navController: NavHostController, viewModel: MainViewModel) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {

        addHomeScreen(navController,this, viewModel)
        addItemCategoriesScreen(this, viewModel)
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
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.ItemCategories.path) {
        ItemCategoriesScreen(viewModel)
    }
}
