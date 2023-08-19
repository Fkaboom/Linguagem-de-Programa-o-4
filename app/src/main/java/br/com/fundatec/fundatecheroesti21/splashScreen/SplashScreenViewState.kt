package br.com.fundatec.fundatecheroesti21.splashScreen

sealed class SplashScreenViewState {
    object ShowHome : SplashScreenViewState();
    object ShowLogin : SplashScreenViewState();
}