package com.mhanifs.newsapp

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.mhanifs.newsapp.core.theme.NewsAppTheme
import com.mhanifs.newsapp.core.utils.Event
import com.mhanifs.newsapp.core.utils.EventBus
import com.mhanifs.newsapp.features.news.presentation.view.NewsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
//                val lifecycle = LocalLifecycleOwner.current.lifecycle
//                LaunchedEffect(key1 = lifecycle) {
//                    repeatOnLifecycle(state = Lifecycle.State.STARTED) {
//                        EventBus.event.collect {event ->
//                            if (event is Event.ToastMessage) {
//                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//                        }
//                    }
//                }
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    NewsScreen()
//                }
                NewsScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun NewsApp() {
    NewsAppTheme {
        NewsScreen()
    }
}
