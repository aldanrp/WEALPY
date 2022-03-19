package com.example.dhaveduvation

import com.google.gson.annotations.SerializedName

data class LoginRespone(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("status")
	val status: Int
)

data class Data(

	@field:SerializedName("nama_member")
	val namaMember: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)
