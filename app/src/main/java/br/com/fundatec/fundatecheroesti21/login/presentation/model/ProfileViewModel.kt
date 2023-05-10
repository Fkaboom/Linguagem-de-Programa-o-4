package br.com.fundatec.fundatecheroesti21.login.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class ProfileViewModel : ViewModel() {

    private val viewState = MutableLiveData<ProfileViewState>()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(nome: String?, email: String?, password: String?) {
        viewState.value = ProfileViewState.ShowLoading
        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")

        val matcher = pattern.matcher(email)

        if (email.isNullOrBlank() && password.isNullOrBlank() && nome.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowErrorMessage
            return
        }
        if (nome.isNullOrBlank()) {
            viewState.value = ProfileViewState.showNameError
            return
        }


        if (password != null) {
            if
                    (password.length > 16 || password.length < 5) {
                viewState.value = ProfileViewState.ShowPwdErrorMessage
                return

            };

            if
                    (matcher.matches() && password.length < 16 && password.length > 5) {
                viewState.value = ProfileViewState.ShowHomeScreen
                return
            };

        } else {
            viewState.value = ProfileViewState.ShowPwdErrorMessage
            return
        }

        viewState.value = ProfileViewState.ShowEmailErrorMessage
        return
    }
}

