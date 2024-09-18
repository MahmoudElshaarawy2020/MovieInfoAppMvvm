package com.example.movieinfoappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieinfoappmvvm.ui.views.BannerScreen
import com.example.movieinfoappmvvm.ui.views.DetailsScreen
import com.example.movieinfoappmvvm.ui.views.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Banner_screen") {
        composable("Banner_screen"){
            BannerScreen(navController = navController)
        }
        composable("Home_screen"){
            HomeScreen(navController = navController)
        }
        composable("Details_screen/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ){
                    type = NavType.IntType
                }
            )
        ){  id ->
            id.arguments?.getInt("id")?.let{id1->
                DetailsScreen(id = id1)

            }


        }

    }
}