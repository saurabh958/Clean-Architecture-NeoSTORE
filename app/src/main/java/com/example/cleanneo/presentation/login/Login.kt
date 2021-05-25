package com.example.cleanneo.presentation.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cleanneo.MainActivity
import com.example.cleanneo.databinding.ActivityLoginBinding
import com.example.cleanneo.domain.model.LoginModel
import com.example.cleanneo.util.App


class Login : AppCompatActivity() {


    var mMainActivity: Login? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mMainActivity= this@Login
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.getLoginListObserver().observe(this, Observer<LoginModel> {
            if (it != null) {
                Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
            }
        })

        binding.login.setOnClickListener {
            Log.d("annu", "in onclick login button")
            var eml=binding.username.text.toString()
            Log.d("annu", eml)
            var pass = binding.passwrd.text.toString()
            viewModel.makeLoginApiCall(eml, pass)
        }

        binding.floatng.setOnClickListener {
            Toast.makeText(applicationContext, "Register page", Toast.LENGTH_SHORT).show()
        }



//        val viewModel: LoginViewModel by viewModels()
//
//        viewModel.getLoginListObserver().observe(this, Observer {
//            if (it != null) {
//                Toast.makeText(applicationContext, "in onchanged", Toast.LENGTH_SHORT).show()
//            }
//        })

    }
}