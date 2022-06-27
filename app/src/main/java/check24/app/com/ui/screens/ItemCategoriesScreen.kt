package check24.app.com.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import check24.app.com.viewmodel.MainViewModel

@Composable
fun ItemCategoriesScreen(
    viewModel: MainViewModel,
    navigateToItemScreen: () -> Unit
) {

    Column {

        if (viewModel.itemsCategoryTitleStrId != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = viewModel.itemsCategoryTitleStrId!!),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
            )
        }

        if (viewModel.products != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(items = viewModel.products!!) { itemCategory ->
                    CategoryItem(
                        navigateToItemScreen, product = itemCategory, viewModel,
                    )
                }
            }
        }
    }
}
