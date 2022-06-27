package check24.app.com.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import vtsen.hashnode.dev.simplerestapidemo.R
import check24.app.com.viewmodel.MainViewModel

@Composable
fun ItemScreen(viewModel: MainViewModel) {

    val product = viewModel.chosenItem
    val uriHandler = LocalUriHandler.current

    Scaffold(
        bottomBar = {
            Text(
                text = "© 2016 Check24",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .clickable {
                        uriHandler.openUri("https://m.check24.de/rechtliche-hinweise/?deviceoutput=app")
                    },
            )
        }
    ) {}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = product!!.name!!,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
        )

        Row(
            modifier = Modifier
                .padding(all = 20.dp),
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
                    .size(150.dp, 150.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(colorStringToColour(product.colorCode))
            )
        }

        product.priceModel!!.value.toString()
            .let { Text(text = "€$it", style = MaterialTheme.typography.h4) }


        product.rating.toString()
            .let { Text(text = "Rating: $it / 5", style = MaterialTheme.typography.body1) }

        Row(
            modifier = Modifier
                .padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = product.description.toString(),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
        }

        Row(
            modifier = Modifier
                .padding(all = 16.dp)
                .verticalScroll(rememberScrollState())
                .border(
                    BorderStroke(2.dp, Color.Gray)
                ),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = product.longDescription.toString(),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
        }

    }

}

