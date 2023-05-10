package br.com.fundatec.fundatecheroesti21.login.presentation.model

sealed class ProfileViewState {
    object ShowEmailErrorMessage : ProfileViewState()
    object ShowErrorMessage : ProfileViewState()
    object ShowHomeScreen : ProfileViewState()
    object ShowPwdErrorMessage : ProfileViewState()
    object ShowLoading : ProfileViewState()
    object showNameError : ProfileViewState()
}