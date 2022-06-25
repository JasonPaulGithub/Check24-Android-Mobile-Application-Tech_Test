package vtsen.hashnode.dev.simplerestapidemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.Products
import vtsen.hashnode.dev.simplerestapidemo.R

@Composable
fun MealCategoryItem(
    product: Products,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Divider(thickness = 2.dp)

        product.name?.let { Text(text = it, style = MaterialTheme.typography.h4) }
        product.description?.let { Text(text = it, style = MaterialTheme.typography.body1) }

        Image(
            painter = rememberImagePainter(
                data = product.imageURL,
                builder = {
                    placeholder(R.drawable.loading_animation)
                }
            ),

            contentDescription = "",

            modifier = Modifier
                .size(150.dp, 150.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color(derp(product.colorCode)))
        )

    }
}

fun derp(colorCode: String?): Int {
    // FFCDD2
    val hex = "0x7FFFFFFF" // with radix specifier
    return Integer.decode(hex)
}
