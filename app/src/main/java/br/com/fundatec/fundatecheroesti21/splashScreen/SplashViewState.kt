package br.com.fundatec.fundatecheroesti21.splashScreen

sealed class SplashViewState {
    object ShowHome : SplashViewState();
    object ShowLogin : SplashViewState();
}