package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initializeObserver()

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registrar.setOnClickListener() {
            viewModel.validateInputs(
                password = binding.pwd.text.toString(),
                email = binding.email.text.toString(),
                nome = binding.nome.text.toString()
            )
        }


    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                ProfileViewState.ShowEmailErrorMessage -> showEmailError()
                ProfileViewState.ShowHomeScreen -> showHome()
                ProfileViewState.ShowPwdErrorMessage -> showPasswordError()
                ProfileViewState.ShowLoading -> showLoading()
                ProfileViewState.showNameError -> showNameError()
                ProfileViewState.ShowErrorMessage -> showSnackError()
            }
        }


    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showPasswordError() {
        binding.pbLoading.hide()
        binding.pwd.error = getString(R.string.login_size_password_error_message)
    }

    private fun showNameError() {
        binding.pbLoading.hide()
        binding.nome.error = getString(R.string.login_name_error_message)
    }

    private fun showHome() {
        binding.pbLoading.hide()
        val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message, Snackbar.LENGTH_LONG).show()
    }

    private fun showEmailError() {
        binding.pbLoading.hide()
        binding.email.error = getString(R.string.login_email_error_message)
    }

}