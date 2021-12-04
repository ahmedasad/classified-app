package com.example.classifiedapp.data.network.services

import com.example.classifiedapp.model.getclassifiedlistresponse.GetClassifiedListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ClassifiedServices {

    companion object{
        const val BASE_URL = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/"
        const val CLASSIFIEDS = ""
    }

    @GET
    suspend fun getClassifieds(): Response<GetClassifiedListResponse>
}