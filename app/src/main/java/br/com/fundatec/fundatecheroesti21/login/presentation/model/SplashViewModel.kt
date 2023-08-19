package br.com.fundatec.fundatecheroesti21.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.splash.domain.IsValidCacheUseCase

import br.com.fundatec.fundatecheroesti21.splashScreen.SplashScreenViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val viewState = MutableLiveData<SplashScreenViewState>()
    val state: LiveData<SplashScreenViewState> = viewState

    private val useCase by lazy { IsValidCacheUseCase() }

    init {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashScreenViewState.ShowHome
            } else {
                viewState.value = SplashScreenViewState.ShowLogin
            }
        }
    }
}