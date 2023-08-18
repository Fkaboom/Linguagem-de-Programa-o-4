package br.com.fundatec.fundatecheroesti21.login.data.remote

data class UserRequest(
    val name: String,
    val email: String,
    val senha: String
)