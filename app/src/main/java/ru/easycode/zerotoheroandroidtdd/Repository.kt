package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

// responsible for data fetching (simulate loading)
interface Repository {

    suspend fun load()

    class Base : Repository {

        override suspend fun load() {
            delay(3000)
        }
    }
}
