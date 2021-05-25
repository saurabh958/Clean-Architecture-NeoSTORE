package com.example.cleanneo.data.source.remote

import com.example.cleanneo.domain.model.LoginModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitService
{

    @FormUrlEncoded
    @POST("login")
    fun checkLoginDetail(@Field("email") email:String ,
                         @Field("password") password: String): Call<LoginModel>

}