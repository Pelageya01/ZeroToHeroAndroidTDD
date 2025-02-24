package ru.easycode.zerotoheroandroidtdd;

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
        private val liveDataWrapper: LiveDataWrapper,
        private val repository: Repository) {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    // Trigger loading, update UI states via liveDataWrapper
    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)

        viewModelScope.launch {
            repository.load() // simulate data loading
            liveDataWrapper.update(UiState.ShowData) // update UI with loaded data
        }
    }
    // save before the process death
    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }
}