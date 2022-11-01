package com.token.api_demo.model.submit_kyc

data class ResponseDetails(
    val accountType: String,
    val addressLine1: String,
    val addressLine2: String,
    val city: String,
    val dob: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val lastName: String,
    val phoneNumber: String,
    val profileStatus: String,
    val requestStatus: String,
    val requestedOn: String,
    val roleName: String,
    val ssn: String,
    val state: String,
    val title: String,
    val updatedOn: String,
    val userType: String,
    val walletNumber: String,
    val zipCode: String
)