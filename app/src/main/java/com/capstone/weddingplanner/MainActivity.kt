package com.capstone.weddingplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.capstone.weddingplanner.ui.WeddingPlannerApp
import com.capstone.weddingplanner.ui.theme.WeddingPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(
//                MaterialTheme.,
//                MaterialTheme.colors.primary.toArgb()
//            ),
//            navigationBarStyle = SystemBarStyle.auto(
//                MaterialTheme.colors.primary.toArgb(),
//                MaterialTheme.colors.primary.toArgb()
//            )
//        )
        setContent {
            WeddingPlannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeddingPlannerApp()
                }
            }
        }
    }
}
