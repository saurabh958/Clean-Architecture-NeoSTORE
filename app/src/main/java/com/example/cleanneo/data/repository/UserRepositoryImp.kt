package com.example.cleanneo.data.repository

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.cleanneo.MainActivity
import com.example.cleanneo.data.source.remote.RetroInstance
import com.example.cleanneo.data.source.remote.RetrofitService
import com.example.cleanneo.domain.model.LoginModel
import com.example.cleanneo.domain.repository.UserRepository
import com.example.cleanneo.presentation.login.Login
import com.example.cleanneo.presentation.login.LoginViewModel
import com.example.cleanneo.util.App
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class UserRepositoryImp(val context: Context) : UserRepository {


    var loginviewmodel: LoginViewModel? = null
    var login: Login = Login()


    override fun logIn(email: String, password: String) {
        Log.d("annu", "in userepoimp $email")

        val retroInstance = RetroInstance.getRetroInstance().create(RetrofitService::class.java)
        val call = retroInstance.checkLoginDetail(email, password)
        Log.d("annu", "val call")
        call.enqueue(object : retrofit2.Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                Log.d("annu", "in onresponse")
                if (response.isSuccessful) {
                    Log.d("annu", "response success")
                    loginviewmodel?.loginlist?.postValue(response.body())
                    Toast.makeText(context, response.body()?.message, Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("annu", "response fail")
                    try {
                        Log.d("annu", "try block")
                        val jObjError = JSONObject(response.errorBody()!!.string())
                        Log.e("annu", jObjError.getString("user_msg"))
                        Toast.makeText(context, jObjError.getString("user_msg"), Toast.LENGTH_SHORT)
                            .show()

                    } catch (e: Exception) {
                        Log.d("annu", "catch block")
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.e("annu", "${t.message}")
                Toast.makeText(context, "Check internet connection", Toast.LENGTH_SHORT).show()
            }
        })
    }


}