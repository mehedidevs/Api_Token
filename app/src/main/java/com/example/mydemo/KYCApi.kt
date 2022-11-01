package com.example.mydemo

import com.fama.famapay.data.model.onboard.login.RequestLogin
import com.fama.famapay.data.model.onboard.login.ResponseLogin
import com.fama.famapay.data.model.onboard.submit_kyc.RequestKYCDetail
import com.fama.famapay.data.model.onboard.submit_kyc.ResponseKYCDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface KYCApi {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("/walletActivation/submitKYCDetail")
     fun submitKYCDetail(
        @Header("jwtToken") token: String,
        @Body request: RequestKYCDetail
    ): Call<Response<ResponseKYCDetail>>

    @PUT("/Register/login")
     fun login(@Body request: RequestLogin): Call<Response<ResponseLogin>>
}