package com.fama.famapay.data.model.onboard.submit_kyc

data class ResponseKYCDetail(
    val message: String,
    val responseDetails: ResponseDetails,
    val statusCode: Int
)