package com.token.api_demo.model.submit_kyc

data class RequestSubmit(
    val addressLine1: String,
    val addressLine2: String,
    val businessDetails: BusinessDetails,
    val city: String,
    val dob: String,
    val ssn: String,
    val state: String,
    val zipCode: String
)