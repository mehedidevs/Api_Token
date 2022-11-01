package com.token.api_demo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mydemo.databinding.BalerLayoutBinding
import com.token.api_demo.model.login.RequestLogin
import com.token.api_demo.model.submit_kyc.BusinessDetails
import com.token.api_demo.model.submit_kyc.RequestSubmit
import com.token.api_demo.viewmodels.KycViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: KycViewModel


    private lateinit var binding: BalerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BalerLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[KycViewModel::class.java]

        binding.loginBtn.setOnClickListener {

            val businessDetails = BusinessDetails(
                "str", "str", "str", "str", 226, "str", "MD", "12345"
            )

            val requestKYCDetail: RequestSubmit =
                RequestSubmit(
                    " addressLine1",
                    " addressLine2",
                    businessDetails,
                    " addressCitY",
                    "1999-10-10",
                    "123456789",
                    "MD",
                    "12345"
                )

            val requestLogin = RequestLogin("hopanab690@hempyl.com", "123456Asdf!")

            viewModel.login(requestLogin)

            Handler().postDelayed({
                viewModel.submitKyc(requestKYCDetail)
            }, 5000)


        }


    }
}