package vtsen.hashnode.dev.simplerestapidemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import vtsen.hashnode.dev.simplerestapidemo.GsonItemModels.ProductModel
import vtsen.hashnode.dev.simplerestapidemo.R

@Composable
fun MealCategoryItem(
    product: ProductModel,
) {
    Column(
        modifier = Modifier
            .clickable { println(product.name) }
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Divider(thickness = 4.dp)

        product.name?.let { Text(text = it, style = MaterialTheme.typography.h4) }
        product.description?.let { Text(text = it, style = MaterialTheme.typography.body1) }
        Text(text = "Price (EUR):", style = MaterialTheme.typography.body1)
        product.priceModel!!.value.toString()
            .let { Text(text = it, style = MaterialTheme.typography.body1) }

        Image(
            painter = rememberImagePainter(
                data = product.imageURL,
                builder = {
                    placeholder(R.drawable.loading_animation)
                }
            ),

            contentDescription = "Item Image",

            modifier = Modifier
                .size(150.dp, 150.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(colorStringToColour(product.colorCode))
        )

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
