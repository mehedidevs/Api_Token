package com.token.api_demo.api

import com.token.api_demo.model.login.RequestLogin
import com.token.api_demo.model.login.ResponseLogin
import com.token.api_demo.model.submit_kyc.RequestSubmit
import com.token.api_demo.model.submit_kyc.ResponseKYCDetail
import retrofit2.Response
import retrofit2.http.*

interface KYCApi {


    @POST("/walletActivation/submitKYCDetail")
    suspend fun submitKYCDetail(
        @Body request: RequestSubmit,
    ): Response<ResponseKYCDetail>

    @PUT("/Register/login")
    suspend fun login(@Body request: RequestLogin): Response<ResponseLogin>
}