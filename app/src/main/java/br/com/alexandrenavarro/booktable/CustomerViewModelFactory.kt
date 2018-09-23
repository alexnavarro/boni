package br.com.alexandrenavarro.booktable

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by alexandrenavarro on 9/23/18.
 */
class CustomerViewModelFactory @Inject constructor(
        private val customerViewModel: CustomerViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomerViewModel::class.java)) {
            return customerViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}