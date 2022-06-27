package check24.app.com.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import check24.app.com.viewmodel.MainViewModel
import coil.compose.rememberImagePainter
import vtsen.hashnode.dev.simplerestapidemo.R

private fun mToast(context: Context) {
    Toast.makeText(context, "Item added to favourites!", Toast.LENGTH_LONG).show()
}

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
                    .padding(all = 8.dp)
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
                .padding(all = 10.dp),
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
                    .size(110.dp, 110.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(colorStringToColour(product.colorCode))
            )
        }

        product.priceModel!!.value.toString()
            .let { Text(text = "€$it", style = MaterialTheme.typography.h4) }


        product.rating.toString()
            .let { Text(text = "Rating: $it / 5", style = MaterialTheme.typography.body1) }

        val mContext = LocalContext.current


        Button(
            onClick = {
                mToast(mContext)

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
        ) {
            Text(text = "Add to favourites", color = Color.White)
        }

        Row(
            modifier = Modifier
                .padding(all = 10.dp),
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
                .padding(all = 10.dp)
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

