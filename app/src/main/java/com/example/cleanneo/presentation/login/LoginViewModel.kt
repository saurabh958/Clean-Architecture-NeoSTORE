package com.example.cleanneo.presentation.login

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.example.cleanneo.data.repository.UserRepositoryImp
import com.example.cleanneo.domain.model.LoginModel
import com.example.cleanneo.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginViewModel(application: Application) : AndroidViewModel(application)
{
    private var context:Context=getApplication()
    var userRepositoryImp:UserRepositoryImp?= UserRepositoryImp(context)
    var userRepository:UserRepository?=null

    var loginlist : MutableLiveData<LoginModel> = MutableLiveData()

    fun getLoginListObserver(): MutableLiveData<LoginModel>{
        return loginlist

    }



        fun makeLoginApiCall(email:String,password:String){
            Log.d("annu","in makeloginapicall$email")
            userRepositoryImp!!.logIn(email,password)

        }


}