package com.fama.famapay.data.model.onboard.submit_kyc

data class BusinessDetails(
    val addressLine2: String,
    val businessName: String,
    val businessRegistrationNumber: String,
    val city: String,
    val countryId: Int,
    val headQuaterAddressLine1: String,
    val state: String,
    val zipCode: String
)