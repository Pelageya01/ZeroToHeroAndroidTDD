package ru.easycode.zerotoheroandroidtdd;

import android.os.Build
import androidx.annotation.RequiresApi

import android.os.Bundle;

interface BundleWrapper {
    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore

    class Base(private val bundle: Bundle) : Mutable {

        override fun save(uiState: UiState){
            bundle.putSerializable(KEY, uiState)
        }

        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        override fun restore(): UiState {
            return bundle.getSerializable(KEY, UiState::class.java) as UiState
        }

        companion object {
            private const val KEY = "uiStateKey"
        }
    }
}
