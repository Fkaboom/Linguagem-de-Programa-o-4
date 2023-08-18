package br.com.fundatec.fundatecheroesti21.login.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.splashScreen.SplashSreenViewState

class SplashViewModel : ViewModel() {
    private val viewState = MutableLiveData<SplashSreenViewState>()
    val state: LiveData<SplashSreenViewState> = viewState

}