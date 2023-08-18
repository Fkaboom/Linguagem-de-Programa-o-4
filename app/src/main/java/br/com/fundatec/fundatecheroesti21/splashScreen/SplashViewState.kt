package br.com.fundatec.fundatecheroesti21.splashScreen

sealed class SplashSreenViewState {
    object loadHome : SplashSreenViewState();
    object loadLogin : SplashSreenViewState();
}