package check24.app.com.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import check24.app.com.dataModels.ProductModel
import vtsen.hashnode.dev.simplerestapidemo.R
import check24.app.com.viewmodel.MainViewModel

@Composable
fun CategoryItem(
    navigateToItemScreen: () -> Unit,
    product: ProductModel,
    viewModel: MainViewModel
) {

    Row(
        modifier = Modifier
            .clickable {
                viewModel.chosenItem(product)
                navigateToItemScreen()
            }
            .border(
                BorderStroke(2.dp, Color.Gray)
            )
            .padding(all = 20.dp)
        ,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Image(
            painter = rememberImagePainter(
                data = product.imageURL,
                builder = {
                    placeholder(R.drawable.loading_animation)
                }
            ),

            contentDescription = product.description,

            modifier = Modifier
                .size(120.dp, 100.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(colorStringToColour(product.colorCode))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            product.name?.let { Text(text = it, style = MaterialTheme.typography.h4) }
            product.description?.let { Text(text = it, style = MaterialTheme.typography.body1)  }
            product.priceModel!!.value.toString()
                .let { Text(text = "Price: €$it", style = MaterialTheme.typography.h4) }
        }
    }

}

fun colorStringToColour(colorCode: String?): Color {
    // Chunks x3 then De-Hex value
    val c = colorCode!!.chunked(2)
    val d1: Int = c[0].toInt(16)
    val d2: Int = c[1].toInt(16)
    val d3: Int = c[2].toInt(16)
    return Color(d1, d2, d3)
}
