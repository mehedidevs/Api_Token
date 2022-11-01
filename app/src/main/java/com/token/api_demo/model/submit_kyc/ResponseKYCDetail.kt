package com.token.api_demo.model.submit_kyc



data class ResponseKYCDetail(
    val message: String,
    val responseDetails: ResponseDetails,
    val statusCode: Int
)