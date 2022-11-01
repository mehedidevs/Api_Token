package com.example.mydemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.mydemo.databinding.ActivityMainBinding
import com.example.mydemo.databinding.BalerLayoutBinding
import com.fama.famapay.data.model.onboard.login.RequestLogin
import com.fama.famapay.data.model.onboard.login.ResponseLogin
import com.fama.famapay.data.model.onboard.submit_kyc.BusinessDetails
import com.fama.famapay.data.model.onboard.submit_kyc.RequestKYCDetail
import com.fama.famapay.data.model.onboard.submit_kyc.ResponseKYCDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: BalerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BalerLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {

            val bussinesDetail = BusinessDetails(
                "str", "str", "str", "str", 226, "str", "MD", "12345"
            )

            var requestKYCDetail: RequestKYCDetail =
                RequestKYCDetail(
                    " addressLine1",
                    " addressLine2",
                    bussinesDetail,
                    " addressCitY",
                    "1999-10-10",
                    "123456789",
                    "MD",
                    "12345"
                )


            var retrofit = MyRetrofit.getRetrofit()

            var loginRequest = RequestLogin("hopanab690@hempyl.com", "123456Asdf!")


            //  retrofit.login(loginRequest).headers()["sessionid"]

            var loginReq = MyRetrofit.getRetrofit().create(KYCApi::class.java)


            var login = loginReq.login(loginRequest)

            login.enqueue(object : Callback<Response<ResponseLogin>> {
                override fun onResponse(
                    call: Call<Response<ResponseLogin>>,
                    response: Response<Response<ResponseLogin>>
                ) {

                    val res = response.body()

                    var token = response.headers()["sessionid"]


                    Log.i("TAG", "Token : ${response.headers()["sessionid"]} ")


                    var save = loginReq.submitKYCDetail("$token", requestKYCDetail)
                    save.enqueue(object : Callback<Response<ResponseKYCDetail>> {
                        override fun onResponse(
                            call: Call<Response<ResponseKYCDetail>>,
                            response: Response<Response<ResponseKYCDetail>>
                        ) {


                            Log.i("TAG", "Save Response: ${response} ")

                        }

                        override fun onFailure(
                            call: Call<Response<ResponseKYCDetail>>,
                            t: Throwable
                        ) {
                            Log.i("TAG", "Save Error: ${t.message} ")
                        }

                    })


                }

                override fun onFailure(call: Call<Response<ResponseLogin>>, t: Throwable) {

                }
            })


        }


    }
}