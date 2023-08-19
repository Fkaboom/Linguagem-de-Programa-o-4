package br.com.fundatec.fundatecheroesti21.login.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.fundatec.fundatecheroesti21.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState
import io.mockk.spyk
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private val viewModel: ProfileViewModel = ProfileViewModel()
    private val stateObserver: Observer<ProfileViewState> = spyk()

    @Test
    fun validate_inputs_when_not_null() {
        viewModel.validateInputs("Teste","teste@gmail.com", "123456")

        Assert.assertEquals(viewModel.state.value, ProfileViewState.ShowHomeScreen)
    }
    @Test
    fun validate_inputs_when_pwd_null() {
        viewModel.validateInputs("teste","teste@gmail.com ",null)

        Assert.assertEquals(viewModel.state.value, ProfileViewState.ShowPwdErrorMessage)
    }

    @Test
    fun validate_inputs_when_name_null() {
        viewModel.validateInputs(null,"teste@gmail.com ","12345")

        Assert.assertEquals(viewModel.state.value, ProfileViewState.showNameError)
    }
}