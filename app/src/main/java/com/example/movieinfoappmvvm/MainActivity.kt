package com.example.movieinfoappmvvm

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieinfoappmvvm.navigation.Navigation
import com.example.movieinfoappmvvm.ui.theme.MovieInfoAppMvvmTheme
import com.example.movieinfoappmvvm.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val linearGradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB226E1),
                Color(0xFFFC6603),
                Color(0xFF5995EE),
                Color(0xFF3D3535)
            ),
            start = Offset(Float.POSITIVE_INFINITY, 0f),
            end = Offset(0f, Float.POSITIVE_INFINITY),
        )
        setContent {
            MovieInfoAppMvvmTheme {
                val movieViewModel = viewModel<MovieViewModel>()
                val state = movieViewModel.state

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(linearGradientBrush)
                ) {
                    Navigation()
                }
            }
        }
    }
}

