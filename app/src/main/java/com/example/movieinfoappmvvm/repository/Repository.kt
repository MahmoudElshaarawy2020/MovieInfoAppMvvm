package com.example.movieinfoappmvvm.repository

import com.example.movieinfoappmvvm.models.Details
import com.example.movieinfoappmvvm.models.MoviesList
import com.example.movieinfoappmvvm.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page:Int): Response<MoviesList>{
        return RetrofitInstance.api.getMovies(page)
    }

    suspend fun getDetailsById(id: Int): Response<Details>{
        return RetrofitInstance.api.getMovieById(id)
    }
}