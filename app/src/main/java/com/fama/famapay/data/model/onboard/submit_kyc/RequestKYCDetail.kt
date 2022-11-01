package com.fama.famapay.data.model.onboard.submit_kyc

data class RequestKYCDetail(
    val addressLine1: String,
    val addressLine2: String,
    val businessDetails: BusinessDetails,
    val city: String,
    val dob: String,
    val ssn: String,
    val state: String,
    val zipCode: String
)