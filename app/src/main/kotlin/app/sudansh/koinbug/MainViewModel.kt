package app.sudansh.koinbug

import androidx.lifecycle.ViewModel
import app.sudansh.domain.PreferencesHelper
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(private val preferencesHelper: PreferencesHelper) : ViewModel() {
    fun refresh() {
        preferencesHelper.refresh()
    }
}