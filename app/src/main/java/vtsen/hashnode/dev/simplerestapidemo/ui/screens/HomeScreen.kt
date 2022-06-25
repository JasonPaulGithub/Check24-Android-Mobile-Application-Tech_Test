package vtsen.hashnode.dev.simplerestapidemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import vtsen.hashnode.dev.simplerestapidemo.R
import vtsen.hashnode.dev.simplerestapidemo.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navigateToMealCategories: () -> Unit,
    viewModel: MainViewModel
) {

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        item {
            DefaultButton(
                text = stringResource(R.string.retrofit_item),
                onClick = {
                    viewModel.updateItemCategories()
                    //navigateToMealCategories()
                },
            )
        }

        item {
            DefaultButton(
                text = stringResource(R.string.retrofit_gson),
                onClick = {
                    viewModel.updateMealCategoriesWithRetrofitGson()
                    navigateToMealCategories()
                },
            )
        }

    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen({}, MainViewModel())
}