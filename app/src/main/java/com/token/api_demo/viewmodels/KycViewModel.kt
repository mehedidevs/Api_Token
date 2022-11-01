package com.token.api_demo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.token.api_demo.api.KYCApi
import com.token.api_demo.model.login.RequestLogin
import com.token.api_demo.model.login.ResponseLogin
import com.token.api_demo.model.submit_kyc.RequestSubmit
import com.token.api_demo.uitils.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class KycViewModel @Inject constructor(val kycApi: KYCApi) : ViewModel() {

    @Inject
    lateinit var tokenManager: TokenManager


    fun submitKyc(requestSubmit: RequestSubmit) {


        viewModelScope.launch {
            val response = kycApi.submitKYCDetail(requestSubmit)

            if (response.isSuccessful) {
                Log.i("TAG", "Success Kyc: ${response.body()} ")
            } else if (response.errorBody() != null) {

                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                Log.i("TAG", "Error Kyc: ${errorObj.getString("message")} ")

                /*
                [size=89 text={"message":"You have already submitted the document, please chec…]
                 */
            }


        }


    }

    fun login(requestLogin: RequestLogin) {

        viewModelScope.launch {
            val response = kycApi.login(requestLogin)

            if (response.isSuccessful) {
                Log.i("TAG", "Success Login: ${response.body()} ")
                var responseLogin: ResponseLogin = response.body()!!
                val token = response.headers()["sessionid"]
                tokenManager.saveToken(token!!)

            } else {
                Log.i("TAG", "Error Login: ${response.errorBody()} ")
            }

        }


    }


}