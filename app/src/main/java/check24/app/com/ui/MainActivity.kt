package check24.app.com.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import check24.app.com.ui.navigation.BuildNavGraph
import check24.app.com.ui.theme.SimpleRestApiAppTheme
import check24.app.com.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel())
        }
    }
}

@Composable
private fun MainScreen(viewModel: MainViewModel) {
    SimpleRestApiAppTheme {
        val navController = rememberNavController()
        BuildNavGraph(navController, viewModel)
    }
}
