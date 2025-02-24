package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.BundleWrapper.Save

interface LiveDataWrapper {

    fun update(value: UiState)

    fun save(bundleWrapper: BundleWrapper.Save)

    fun liveData(): LiveData<UiState>

    class Base( private val liveData: MutableLiveData<UiState> = SingleLiveEvent()) : LiveDataWrapper {

        override fun save (bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData() = liveData
    }
}

