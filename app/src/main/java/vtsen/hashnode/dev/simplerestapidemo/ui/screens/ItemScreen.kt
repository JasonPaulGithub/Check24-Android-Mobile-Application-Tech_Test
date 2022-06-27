package vtsen.hashnode.dev.simplerestapidemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import vtsen.hashnode.dev.simplerestapidemo.R
import vtsen.hashnode.dev.simplerestapidemo.viewmodel.MainViewModel

@Composable
fun ItemScreen(viewModel: MainViewModel) {

    val product = viewModel.chosenItem

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = product!!.name!!,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
        )

        product.priceModel!!.value.toString()
            .let { Text(text = "€$it", style = MaterialTheme.typography.h4) }

        Image(
            painter = rememberImagePainter(
                data = product.imageURL,
                builder = {
                    placeholder(R.drawable.loading_animation)
                }
            ),

            contentDescription = product.longDescription,

            modifier = Modifier
                .size(150.dp, 150.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(colorStringToColour(product.colorCode))
            )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = product.description!!,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
        )

    }

}

