package check24.app.com.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import vtsen.hashnode.dev.simplerestapidemo.R
import check24.app.com.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navigateToItemCategories: () -> Unit,
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
                    viewModel.callAndParseItems()
                    navigateToItemCategories()
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